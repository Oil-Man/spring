package com.oilman.springboot2.websocket;

/**
 * 描述：浏览器向服务端发送的消息
 * Created by wangcw on 2019/4/24.
 */
public class B2SMessage {
    private String requestMessage;

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }
}
