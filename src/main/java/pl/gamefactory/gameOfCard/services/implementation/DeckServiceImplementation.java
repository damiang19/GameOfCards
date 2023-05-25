package pl.gamefactory.gameOfCard.services.implementation;

import org.springframework.stereotype.Service;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.enums.Cards;
import pl.gamefactory.gameOfCard.repository.DeckRepository;
import pl.gamefactory.gameOfCard.services.DeckService;
import pl.gamefactory.gameOfCard.services.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeckServiceImplementation implements DeckService {

    private final DeckRepository deckRepository;
    private final UserService userService;

    private final SequenceGeneratorService sequenceGeneratorService;

    public DeckServiceImplementation(DeckRepository deckRepository, UserService userService, SequenceGeneratorService sequenceGeneratorService) {
        this.deckRepository = deckRepository;
        this.userService = userService;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }


    @Override
    public Deck createDeck() {
        Deck deck = new Deck();
        deck.setId(sequenceGeneratorService.generateSequence(Deck.SEQUENCE_NAME));
        List<Cards> cardsList = new ArrayList<>(List.of(Cards.values()));
        Collections.shuffle(cardsList);
        deck.setCards(cardsList);
        return deckRepository.save(deck);
    }

    @Override
    public Deck save(Deck deck) {
        return deckRepository.save(deck);
    }

}
