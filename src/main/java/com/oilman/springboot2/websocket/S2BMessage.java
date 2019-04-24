package com.oilman.springboot2.websocket;

/**
 * 描述：服务端向浏览器发送的消息
 * Created by wangcw on 2019/4/24.
 */
public class S2BMessage {
    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
