package com.lcy.config;

import com.lcy.controller.ws.WebSocketJsonApiHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author liuweijin
 * @date 2023-03-08
 * @desc
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketJsonApiHandler webSocketJsonApiHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketJsonApiHandler , "/" + "learn" + "/ws")
                .setAllowedOriginPatterns("*");

    }
}
