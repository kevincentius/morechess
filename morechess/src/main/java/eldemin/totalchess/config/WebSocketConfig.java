package eldemin.totalchess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import eldemin.stub.SimpleWebSocketHandler;

@Configuration
@ComponentScan(basePackages = { "eldemin" })
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	@Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(simpleWebSocketHandler(), "/test")
        		.setAllowedOrigins("*")
        		.addInterceptors(new WebsocketHandshakeInterceptor());
    }

	@Bean
	public SimpleWebSocketHandler simpleWebSocketHandler() {
		return new SimpleWebSocketHandler();
	}

}