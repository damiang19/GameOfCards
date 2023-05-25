package pl.gamefactory.gameOfCard.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import pl.gamefactory.gameOfCard.services.LobbyService;
import pl.gamefactory.gameOfCard.services.DeckService;
import pl.gamefactory.gameOfCard.entities.Lobby;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api")
public class LobbyController {

    private final LobbyService lobbyService;

    public LobbyController(LobbyService lobbyService, DeckService deckService) {
        this.lobbyService = lobbyService;
    }

    @PostMapping("/lobby/create")
    public ResponseEntity<Lobby> createLobby() {
        return ResponseEntity.status(HttpStatus.CREATED).body(lobbyService.createLobby());
    }
}
