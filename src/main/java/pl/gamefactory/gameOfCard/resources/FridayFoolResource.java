package pl.gamefactory.gameOfCard.resources;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import pl.gamefactory.gameOfCard.dto.FrontendResponseDTO;
import pl.gamefactory.gameOfCard.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class FridayFoolResource {

    private final UserService userService;


    public FridayFoolResource(UserService userService) {
        this.userService = userService;
    }

    @MessageMapping("/game")
    @SendTo("/topic/friday-fool")
    public FrontendResponseDTO  updateGameLobby(@Payload FrontendResponseDTO frontendResponseDTO) throws Exception {
        return null;
    }
}
