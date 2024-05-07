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

package tech.ordinaryroad.live.chat.client.commons.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * @author mjz
 * @date 2024/3/20
 */
public class OrLiveChatHttpUtil extends HttpUtil {

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36";
    private static final ProxyProperties PROXY_PROPERTIES = new ProxyProperties();

    static {
        GlobalHeaders.INSTANCE.header(Header.USER_AGENT, USER_AGENT);
    }

    public static void updateProxyHost(String host) {
        PROXY_PROPERTIES.setHost(host);
    }

    public static void updateProxyPort(int port) {
        PROXY_PROPERTIES.setPort(port);
    }

    public static void updateProxyUsername(String username) {
        PROXY_PROPERTIES.setUsername(username);
    }

    public static void updateProxyPassword(String password) {
        PROXY_PROPERTIES.setPassword(password);
    }

    public static HttpRequest createRequest(Method method, String url) {
        return setRequestSocks5Proxy(HttpUtil.createRequest(method, url));
    }

    public static HttpRequest createGet(String url, boolean isFollowRedirects) {
        return setRequestSocks5Proxy(HttpUtil.createGet(url, isFollowRedirects));
    }

    public static HttpRequest createGet(String url) {
        return setRequestSocks5Proxy(HttpUtil.createGet(url));
    }

    public static HttpRequest createPost(String url) {
        return setRequestSocks5Proxy(HttpUtil.createPost(url));
    }

    public static HttpRequest setRequestSocks5Proxy(HttpRequest request) {
        String host = PROXY_PROPERTIES.getHost();
        if (StrUtil.isNotBlank(host)) {
            request.setProxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(host, PROXY_PROPERTIES.getPort())));
            String username = PROXY_PROPERTIES.getUsername();
            if (StrUtil.isNotBlank(username)) {
                request.basicProxyAuth(username, PROXY_PROPERTIES.getPassword());
            }
        }
        return request;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProxyProperties {
        private String host;
        private int port;
        private String username;
        private String password;
    }
}
