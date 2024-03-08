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

package tech.ordinaryroad.live.chat.client.websocket.client;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import lombok.extern.slf4j.Slf4j;
import tech.ordinaryroad.live.chat.client.commons.base.listener.IBaseConnectionListener;
import tech.ordinaryroad.live.chat.client.servers.netty.client.base.BaseNettyClient;
import tech.ordinaryroad.live.chat.client.websocket.WebSocketCmdEnum;
import tech.ordinaryroad.live.chat.client.websocket.config.WebSocketLiveChatClientConfig;
import tech.ordinaryroad.live.chat.client.websocket.listener.IWebSocketConnectionListener;
import tech.ordinaryroad.live.chat.client.websocket.listener.IWebSocketMsgListener;
import tech.ordinaryroad.live.chat.client.websocket.msg.base.IWebSocketMsg;
import tech.ordinaryroad.live.chat.client.websocket.netty.handler.WebSocketBinaryFrameHandler;
import tech.ordinaryroad.live.chat.client.websocket.netty.handler.WebSocketConnectionHandler;

/**
 * @author mjz
 * @date 2024/3/8
 */
@Slf4j
public class WebSocketLiveChatClient extends BaseNettyClient<
        WebSocketLiveChatClientConfig,
        WebSocketCmdEnum,
        IWebSocketMsg,
        IWebSocketMsgListener,
        WebSocketConnectionHandler,
        WebSocketBinaryFrameHandler
        > {

    public WebSocketLiveChatClient(WebSocketLiveChatClientConfig config, IWebSocketMsgListener msgListener, IWebSocketConnectionListener connectionListener, EventLoopGroup workerGroup) {
        super(config, workerGroup, connectionListener);
        addMsgListener(msgListener);

        // 初始化
        this.init();
    }

    public WebSocketLiveChatClient(WebSocketLiveChatClientConfig config, IWebSocketMsgListener msgListener, IWebSocketConnectionListener connectionListener) {
        this(config, msgListener, connectionListener, new NioEventLoopGroup());
    }

    public WebSocketLiveChatClient(WebSocketLiveChatClientConfig config, IWebSocketMsgListener msgListener) {
        this(config, msgListener, null, new NioEventLoopGroup());
    }

    public WebSocketLiveChatClient(WebSocketLiveChatClientConfig config) {
        this(config, null);
    }

    @Override
    public WebSocketConnectionHandler initConnectionHandler(IBaseConnectionListener<WebSocketConnectionHandler> clientConnectionListener) {
        return new WebSocketConnectionHandler(
                WebSocketClientHandshakerFactory.newHandshaker(getWebsocketUri(), WebSocketVersion.V13, null, true, new DefaultHttpHeaders(), getConfig().getMaxFramePayloadLength()),
                WebSocketLiveChatClient.this, clientConnectionListener
        );
    }

    @Override
    public WebSocketBinaryFrameHandler initBinaryFrameHandler() {
        return new WebSocketBinaryFrameHandler(super.msgListeners, WebSocketLiveChatClient.this);
    }
}
