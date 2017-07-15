package eldemin.stub;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@Controller
public class SimpleWebSocketHandler extends TextWebSocketHandler {
	
	private int count = 0;
	
	private static final Logger LOGGER = Logger.getLogger(SimpleWebSocketHandler.class); 
	
	@Autowired
	private TestService testService;
	
	
	
	@Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	count++;
    	LOGGER.debug("Received message. Count = " + count);
    	session.getAttributes().forEach((key, value) -> System.out.println(key + "->" + value));
    	if (testService != null) {
    		System.out.println(testService.test());
    	} else {
    		System.out.println("testService is null");
    	}
        session.sendMessage(new TextMessage("Connection is all right."));
    }
}