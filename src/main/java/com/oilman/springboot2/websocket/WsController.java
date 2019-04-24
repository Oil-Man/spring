package com.oilman.springboot2.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * 描述：WebSocket演示控制器
 * Created by wangcw on 2019/4/24.
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getServerMessage")
    public S2BMessage say(B2SMessage b2SMessage) throws Exception{
        Thread.sleep(3000);
        S2BMessage s2BMessage = new S2BMessage();
        s2BMessage.setResponseMessage("Welcome, " + b2SMessage.getRequestMessage() + " !");
        return s2BMessage;
    }
}
