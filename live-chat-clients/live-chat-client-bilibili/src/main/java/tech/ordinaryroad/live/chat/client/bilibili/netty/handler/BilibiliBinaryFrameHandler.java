/*
 * MIT License
 *
 * Copyright (c) 2023 OrdinaryRoad
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package tech.ordinaryroad.live.chat.client.bilibili.netty.handler;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.StrUtil;
import io.netty.channel.ChannelHandler;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import tech.ordinaryroad.live.chat.client.bilibili.client.BilibiliLiveChatClient;
import tech.ordinaryroad.live.chat.client.bilibili.listener.IBilibiliMsgListener;
import tech.ordinaryroad.live.chat.client.codec.bilibili.constant.BilibiliCmdEnum;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.*;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.base.BaseBilibiliMsg;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.base.IBilibiliMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.ICmdMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.IMsg;
import tech.ordinaryroad.live.chat.client.servers.netty.client.handler.BaseNettyClientBinaryFrameHandler;

import java.util.List;


/**
 * 消息处理器
 *
 * @author mjz
 * @date 2023/1/4
 */
@Slf4j
@ChannelHandler.Sharable
public class BilibiliBinaryFrameHandler extends BaseNettyClientBinaryFrameHandler<BilibiliLiveChatClient, BilibiliBinaryFrameHandler, BilibiliCmdEnum, IBilibiliMsg, IBilibiliMsgListener> {

    /**
     * 房间号，短房间号
     */
    @Getter
    private final Pair<Object, Object> roomIdPair;

    public BilibiliBinaryFrameHandler(List<IBilibiliMsgListener> msgListeners, BilibiliLiveChatClient client) {
        super(msgListeners, client);
        this.roomIdPair = Pair.of(client.getRoomInitResult().getRoomPlayInfoResult().getRoom_id(), client.getRoomInitResult().getRoomPlayInfoResult().getShort_id());
    }

    public BilibiliBinaryFrameHandler(List<IBilibiliMsgListener> msgListeners, long roomId, Pair<Object, Object> roomIdPair) {
        super(msgListeners, roomId);
        this.roomIdPair = roomIdPair;
    }

    @Override
    public void onUnknownCmd(BilibiliBinaryFrameHandler binaryFrameHandler, String cmdString, IMsg msg) {
        if (cmdString.startsWith("DANMU_MSG")) {
            MessageMsg messageMsg = (MessageMsg) msg;
            DanmuMsgMsg danmuMsgMsg = new DanmuMsgMsg();
            danmuMsgMsg.setProtover(messageMsg.getProtover());
            danmuMsgMsg.setInfo(messageMsg.getInfo());
            danmuMsgMsg.setDm_v2(StrUtil.toStringOrNull(messageMsg.getUnknownProperties().get("dm_v2")));
            iteratorMsgListeners(msgListener -> msgListener.onDanmuMsg(BilibiliBinaryFrameHandler.this, danmuMsgMsg));
        } else {
            super.onUnknownCmd(binaryFrameHandler, cmdString, msg);
        }
    }

    @SneakyThrows
    @Override
    public void onCmdMsg(BilibiliCmdEnum cmd, ICmdMsg<BilibiliCmdEnum> cmdMsg) {
        if (super.msgListeners.isEmpty()) {
            return;
        }

        MessageMsg messageMsg = (MessageMsg) cmdMsg;
        switch (cmd) {
            case DANMU_MSG: {
                DanmuMsgMsg danmuMsgMsg = new DanmuMsgMsg();
                danmuMsgMsg.setProtover(messageMsg.getProtover());
                danmuMsgMsg.setInfo(messageMsg.getInfo());
                danmuMsgMsg.setDm_v2(StrUtil.toStringOrNull(messageMsg.getUnknownProperties().get("dm_v2")));
                iteratorMsgListeners(msgListener -> msgListener.onDanmuMsg(BilibiliBinaryFrameHandler.this, danmuMsgMsg));
                break;
            }

            case SEND_GIFT: {
                SendGiftMsg sendGiftMsg = new SendGiftMsg();
                sendGiftMsg.setRoomId(getRoomIdAsLong());
                sendGiftMsg.setProtover(messageMsg.getProtover());
                SendGiftMsg.Data data = BaseBilibiliMsg.OBJECT_MAPPER.treeToValue(messageMsg.getData(), SendGiftMsg.Data.class);
                sendGiftMsg.setData(data);
                iteratorMsgListeners(msgListener -> msgListener.onGiftMsg(BilibiliBinaryFrameHandler.this, sendGiftMsg));
                break;
            }

            case SUPER_CHAT_MESSAGE: {
                SuperChatMessageMsg superChatMessageMsg = new SuperChatMessageMsg();
                superChatMessageMsg.setProtover(messageMsg.getProtover());
                superChatMessageMsg.setRoomid(messageMsg.getRoomid());
                SuperChatMessageMsg.Data data = BaseBilibiliMsg.OBJECT_MAPPER.treeToValue(messageMsg.getData(), SuperChatMessageMsg.Data.class);
                superChatMessageMsg.setData(data);
                iteratorMsgListeners(msgListener -> msgListener.onSuperChatMsg(BilibiliBinaryFrameHandler.this, superChatMessageMsg));
                break;
            }

            case INTERACT_WORD: {
                InteractWordMsg interactWordMsg = new InteractWordMsg();
                interactWordMsg.setProtover(messageMsg.getProtover());
                InteractWordMsg.Data data = BaseBilibiliMsg.OBJECT_MAPPER.treeToValue(messageMsg.getData(), InteractWordMsg.Data.class);
                interactWordMsg.setData(data);
                iteratorMsgListeners(msgListener -> msgListener.onEnterRoomMsg(BilibiliBinaryFrameHandler.this, interactWordMsg));
                break;
            }

            case ENTRY_EFFECT: {
                iteratorMsgListeners(msgListener -> msgListener.onEntryEffect(BilibiliBinaryFrameHandler.this, messageMsg));
                break;
            }

            case ONLINE_RANK_COUNT:
            case WATCHED_CHANGE:
            case LIKE_INFO_V3_UPDATE: {
                BilibiliRoomStatsMsg bilibiliRoomStatsMsg = BaseBilibiliMsg.OBJECT_MAPPER.convertValue(messageMsg, BilibiliRoomStatsMsg.class);
                iteratorMsgListeners(msgListener -> msgListener.onRoomStatsMsg(BilibiliBinaryFrameHandler.this, bilibiliRoomStatsMsg));
                break;
            }

            case LIKE_INFO_V3_CLICK: {
                LikeInfoV3ClickMsg likeInfoV3ClickMsg = new LikeInfoV3ClickMsg();
                likeInfoV3ClickMsg.setProtover(messageMsg.getProtover());
                LikeInfoV3ClickMsg.Data data = BaseBilibiliMsg.OBJECT_MAPPER.treeToValue(messageMsg.getData(), LikeInfoV3ClickMsg.Data.class);
                likeInfoV3ClickMsg.setData(data);
                iteratorMsgListeners(msgListener -> msgListener.onLikeMsg(BilibiliBinaryFrameHandler.this, likeInfoV3ClickMsg));
                break;
            }

            case LIVE:
            case STOP_LIVE_ROOM_LIST: {
                BilibiliLiveStatusChangeMsg bilibiliLiveStatusChangeMsg = BaseBilibiliMsg.OBJECT_MAPPER.convertValue(messageMsg, BilibiliLiveStatusChangeMsg.class);
                bilibiliLiveStatusChangeMsg.setRoomIdPair(getRoomIdPair());
                iteratorMsgListeners(msgListener -> msgListener.onLiveStatusMsg(BilibiliBinaryFrameHandler.this, bilibiliLiveStatusChangeMsg));
                break;
            }

            default: {
                iteratorMsgListeners(msgListener -> msgListener.onOtherCmdMsg(BilibiliBinaryFrameHandler.this, cmd, cmdMsg));
            }
        }
    }
}
