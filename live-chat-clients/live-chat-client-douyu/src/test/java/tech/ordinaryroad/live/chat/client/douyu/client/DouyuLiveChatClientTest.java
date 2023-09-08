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

package tech.ordinaryroad.live.chat.client.douyu.client;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import tech.ordinaryroad.live.chat.client.commons.base.msg.BaseCmdMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.BaseMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.IMsg;
import tech.ordinaryroad.live.chat.client.douyu.config.DouyuLiveChatClientConfig;
import tech.ordinaryroad.live.chat.client.douyu.constant.DouyuCmdEnum;
import tech.ordinaryroad.live.chat.client.douyu.listener.IDouyuConnectionListener;
import tech.ordinaryroad.live.chat.client.douyu.listener.IDouyuDouyuCmdMsgListener;
import tech.ordinaryroad.live.chat.client.douyu.msg.ChatmsgMsg;
import tech.ordinaryroad.live.chat.client.douyu.msg.DgbMsg;
import tech.ordinaryroad.live.chat.client.douyu.netty.handler.DouyuBinaryFrameHandler;
import tech.ordinaryroad.live.chat.client.douyu.netty.handler.DouyuConnectionHandler;

/**
 * @author mjz
 * @date 2023/8/26
 */
@Slf4j
class DouyuLiveChatClientTest implements IDouyuConnectionListener, IDouyuDouyuCmdMsgListener {

    static Object lock = new Object();
    DouyuLiveChatClient client;

    @Test
    void example() throws InterruptedException {
        DouyuLiveChatClientConfig config = DouyuLiveChatClientConfig.builder()
                // TODO 修改房间id（支持短id）
                .roomId(74751)
                .build();

        client = new DouyuLiveChatClient(config, new IDouyuDouyuCmdMsgListener() {
            @Override
            public void onMsg(DouyuBinaryFrameHandler binaryFrameHandler, IMsg msg) {
                IDouyuDouyuCmdMsgListener.super.onMsg(binaryFrameHandler, msg);

                log.debug("{} 收到{}消息 {}", binaryFrameHandler.getRoomId(), msg.getClass(), msg);
            }

            @Override
            public void onDanmuMsg(DouyuBinaryFrameHandler binaryFrameHandler, ChatmsgMsg msg) {
                IDouyuDouyuCmdMsgListener.super.onDanmuMsg(binaryFrameHandler, msg);

                log.info("{} 收到弹幕 {}({})：{}", binaryFrameHandler.getRoomId(), msg.getUsername(), msg.getUid(), msg.getContent());
            }

            @Override
            public void onGiftMsg(DouyuBinaryFrameHandler binaryFrameHandler, DgbMsg msg) {
                IDouyuDouyuCmdMsgListener.super.onGiftMsg(binaryFrameHandler, msg);

                log.info("{} 收到礼物 {}({}) {} {}({})x{}({})", binaryFrameHandler.getRoomId(), msg.getUsername(), msg.getUid(), "赠送", msg.getGiftName(), msg.getGiftId(), msg.getGiftCount(), msg.getGiftPrice());
            }

            @Override
            public void onCmdMsg(DouyuBinaryFrameHandler binaryFrameHandler, DouyuCmdEnum cmd, BaseCmdMsg<DouyuCmdEnum> cmdMsg) {
                IDouyuDouyuCmdMsgListener.super.onCmdMsg(binaryFrameHandler, cmd, cmdMsg);

                log.info("{} 收到CMD消息{} {}", binaryFrameHandler.getRoomId(), cmd, cmdMsg);
            }

            @Override
            public void onOtherCmdMsg(DouyuBinaryFrameHandler binaryFrameHandler, DouyuCmdEnum cmd, BaseCmdMsg<DouyuCmdEnum> cmdMsg) {
                IDouyuDouyuCmdMsgListener.super.onOtherCmdMsg(binaryFrameHandler, cmd, cmdMsg);

                log.debug("{} 收到其他CMD消息 {}", binaryFrameHandler.getRoomId(), cmd);
            }

            @Override
            public void onUnknownCmd(DouyuBinaryFrameHandler binaryFrameHandler, String cmdString, BaseMsg msg) {
                IDouyuDouyuCmdMsgListener.super.onUnknownCmd(binaryFrameHandler, cmdString, msg);

                log.debug("{} 收到未知CMD消息 {}", binaryFrameHandler.getRoomId(), cmdString);
            }
        }, new IDouyuConnectionListener() {
            @Override
            public void onConnected(DouyuConnectionHandler connectionHandler) {
                log.info("{} onConnected", connectionHandler.getRoomId());
            }

            @Override
            public void onConnectFailed(DouyuConnectionHandler connectionHandler) {
                log.info("{} onConnectFailed", connectionHandler.getRoomId());
            }

            @Override
            public void onDisconnected(DouyuConnectionHandler connectionHandler) {
                log.info("{} onDisconnected", connectionHandler.getRoomId());
            }
        });
        client.connect();

        // 防止测试时直接退出
        while (true) {
            synchronized (lock) {
                lock.wait();
            }
        }
    }

    @Test
    void multiplyClient() throws InterruptedException {
        DouyuLiveChatClientConfig config1 = DouyuLiveChatClientConfig.builder().roomId(890074).build();
        DouyuLiveChatClient client1 = new DouyuLiveChatClient(config1, DouyuLiveChatClientTest.this, DouyuLiveChatClientTest.this);

        DouyuLiveChatClientConfig config2 = DouyuLiveChatClientConfig.builder().roomId(718133).build();
        DouyuLiveChatClient client2 = new DouyuLiveChatClient(config2, DouyuLiveChatClientTest.this, DouyuLiveChatClientTest.this);

        client1.connect(() -> {
            log.warn("client1 connect successfully, start connecting client2");
            client2.connect(() -> {
                log.warn("client2 connect successfully");
            });
        });

        // 防止测试时直接退出
        while (true) {
            synchronized (lock) {
                lock.wait();
            }
        }
    }

    @Test
    void sendDanmu() throws InterruptedException {
        String cookie = System.getenv("cookie");
//        cookie = null;
        log.error("cookie: {}", cookie);
        DouyuLiveChatClientConfig config = DouyuLiveChatClientConfig.builder()
                .cookie(cookie)
                // TODO 修改弹幕发送最短时间间隔，默认3s
                .minSendDanmuPeriod(10 * 1000)
                // TODO 修改房间id（支持短id）
                .roomId(74751)
                .build();
        client = new DouyuLiveChatClient(DouyuLiveChatClient.MODE_WS, config, new IDouyuDouyuCmdMsgListener() {
            @Override
            public void onMsg(IMsg msg) {
                IDouyuDouyuCmdMsgListener.super.onMsg(msg);

//                log.debug("收到消息 {}", msg.getClass());
            }

            @Override
            public void onCmdMsg(DouyuCmdEnum cmd, BaseCmdMsg<DouyuCmdEnum> cmdMsg) {
                IDouyuDouyuCmdMsgListener.super.onCmdMsg(cmd, cmdMsg);

                log.debug("收到CMD消息 {} {}", cmd, cmdMsg);
            }

            @Override
            public void onUnknownCmd(String cmdString, BaseMsg msg) {
                IDouyuDouyuCmdMsgListener.super.onUnknownCmd(cmdString, msg);

                log.debug("收到未知CMD消息 {} {}", cmdString, msg);
            }
        }, new IDouyuConnectionListener() {
            @Override
            public void onConnected(DouyuConnectionHandler connectionHandler) {
                log.error("{} onConnected", connectionHandler.getRoomId());
            }

            @Override
            public void onConnectFailed(DouyuConnectionHandler connectionHandler) {
                log.error("{} onConnectFailed", connectionHandler.getRoomId());
            }

            @Override
            public void onDisconnected(DouyuConnectionHandler connectionHandler) {
                log.error("{} onDisconnected", connectionHandler.getRoomId());
            }
        }, new NioEventLoopGroup());
        client.connect(() -> {
            String danmu = "666" + RandomUtil.randomNumbers(1);
            log.error("连接成功，5s后发送弹幕{}", danmu);
            client.getWorkerGroup().execute(() -> {
                ThreadUtil.sleep(5000);
                while (true) {
                    String s = RandomUtil.randomNumbers(2);
                    log.error("发送弹幕{}", danmu + s);
                    client.sendDanmu(danmu + s);
                    ThreadUtil.sleep(2000);
                }
            });
        });

        // 防止测试时直接退出
        while (true) {
            synchronized (lock) {
                lock.wait();
            }
        }
    }

    @Override
    public void onConnected(DouyuConnectionHandler connectionHandler) {
        log.info("{} onConnected", connectionHandler.getRoomId());
    }

    @Override
    public void onConnectFailed(DouyuConnectionHandler connectionHandler) {
        log.info("{} onConnectFailed", connectionHandler.getRoomId());
    }

    @Override
    public void onDisconnected(DouyuConnectionHandler connectionHandler) {
        log.info("{} onDisconnected", connectionHandler.getRoomId());
    }

    @Override
    public void onDanmuMsg(DouyuBinaryFrameHandler binaryFrameHandler, ChatmsgMsg msg) {
        IDouyuDouyuCmdMsgListener.super.onDanmuMsg(binaryFrameHandler, msg);

        log.info("{} 收到弹幕 {}({})：{}", binaryFrameHandler.getRoomId(), msg.getNn(), msg.getUid(), msg.getTxt());
    }
}