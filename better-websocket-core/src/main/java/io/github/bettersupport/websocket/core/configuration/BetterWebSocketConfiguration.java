package io.github.bettersupport.websocket.core.configuration;

import io.github.bettersupport.websocket.core.exception.WebSocketServerException;
import io.github.bettersupport.websocket.core.properties.BetterWebSocketProperties;
import io.github.bettersupport.websocket.core.ws.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wang.wencheng
 * @date 2021-8-4
 * @remark
 */
@Configuration
@EnableConfigurationProperties(BetterWebSocketProperties.class)
public class BetterWebSocketConfiguration {

    @Autowired
    private BetterWebSocketProperties properties;

    @Bean
    public void initWebSocketServer() {

        WebSocketServer socketServer = new WebSocketServer(properties);
        try {
            socketServer.start();
        } catch (Exception e) {
            throw new WebSocketServerException(e);
        }

    }
}
