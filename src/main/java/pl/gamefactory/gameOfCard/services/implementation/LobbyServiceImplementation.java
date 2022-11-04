package pl.gamefactory.gameOfCard.services.implementation;

import org.springframework.stereotype.Service;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.Lobby;
import pl.gamefactory.gameOfCard.entities.User;
import pl.gamefactory.gameOfCard.entities.enums.GameType;
import pl.gamefactory.gameOfCard.repository.LobbyRepository;
import pl.gamefactory.gameOfCard.services.DeckService;
import pl.gamefactory.gameOfCard.services.LobbyService;
import pl.gamefactory.gameOfCard.services.UserService;
import pl.gamefactory.gameOfCard.utils.SecurityUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class LobbyServiceImplementation implements LobbyService {

    private final LobbyRepository lobbyRepository;
    private final UserService userService;

    private final DeckService deckService;

    public LobbyServiceImplementation(LobbyRepository lobbyRepository, UserService userService, DeckService deckService) {
        this.lobbyRepository = lobbyRepository;
        this.userService = userService;
        this.deckService = deckService;
    }


    @Override
    public Lobby createLobby() {
        Lobby lobby = new Lobby();
        lobby.setId(1L);
        lobby.setEnabled(false);
        Deck deck = deckService.createDeck();
        lobby.setDeckId(deck.getId());
        lobby.setGameType(GameType.FRIDAY_FOOL);
        List<User> userList = new ArrayList<>();
        userList.add(userService.findByUsername(SecurityUtils.getCurrentUserLogin().get()));
        userList.get(0).setDeckId(deck.getId());
        lobby.setPlayers(userList);
        return lobbyRepository.save(lobby);
    }
}
