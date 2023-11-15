package pl.gamefactory.gameOfCard.services.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gamefactory.gameOfCard.dto.Cards;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.repository.DeckRepository;
import pl.gamefactory.gameOfCard.services.DeckService;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class DeckServiceImpl implements DeckService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final DeckRepository deckRepository;

    public DeckServiceImpl(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }


    @Override
    @Transactional
    public Mono<Deck> generateDeck() {
        log.debug("Request to generate deck");
        return deckRepository.save(Deck.builder()
                .cards(Cards.generateDeck())
                .pile(new ArrayList<>())
                .remainingCards(52)
                .build());
    }

    @Override
    public Deck save(Deck deck) {
        return null;
    }
}
