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

    private final SequenceGeneratorService sequenceGeneratorService;

    public LobbyServiceImplementation(LobbyRepository lobbyRepository, UserService userService, DeckService deckService, SequenceGeneratorService sequenceGeneratorService) {
        this.lobbyRepository = lobbyRepository;
        this.userService = userService;
        this.deckService = deckService;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }


    @Override
    public Lobby createLobby() {
        Deck deck = deckService.createDeck();
        List<User> userList = new ArrayList<>();
        userList.add(userService.findByUsername(SecurityUtils.getCurrentUserLogin().get()));
        userList.get(0).setDeckId(deck.getId());
        userService.save(userList.get(0));

        Lobby lobby = new Lobby();
        lobby.setId(sequenceGeneratorService.generateSequence(Lobby.SEQUENCE_NAME));
        lobby.setEnabled(false);
        lobby.setGameType(GameType.FRIDAY_FOOL);
        lobby.setPlayers(userList);

        return lobbyRepository.save(lobby);
    }
}
