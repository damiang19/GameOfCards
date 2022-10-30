package pl.gamefactory.gameOfCard.resources;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.gamefactory.gameOfCard.dto.FakeDto;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketResource {

    public WebSocketResource() {
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public FakeDto  send(@Payload FakeDto fakeDto) throws Exception {
        return fakeDto;
    }
}
