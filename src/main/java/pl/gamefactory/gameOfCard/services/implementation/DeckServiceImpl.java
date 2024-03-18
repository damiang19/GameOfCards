package pl.gamefactory.gameOfCard.services.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gamefactory.gameOfCard.dto.Cards;
import pl.gamefactory.gameOfCard.dto.UpdatePilePayload;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.Pile;
import pl.gamefactory.gameOfCard.repository.DeckRepository;
import pl.gamefactory.gameOfCard.services.DeckService;
import pl.gamefactory.gameOfCard.services.PileService;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final PileService pileService;
    private final DeckRepository deckRepository;

    public DeckServiceImpl(PileService pileService, DeckRepository deckRepository) {
        this.pileService = pileService;
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
    public Mono<Deck> getDeckById(String deckId) {
        log.debug("Request to get deck with id : {}", deckId);
        return deckRepository.findById(deckId);
    }
    @Override
    public Mono<Pile> updateDeckPile(UpdatePilePayload updatePilePayload) {
        String pileName = updatePilePayload.pileName();
        String deckId = updatePilePayload.deckId();
        log.debug("Request to update pile: {} for deck with id: {}", pileName, deckId);
        return getDeckById(deckId)
                .map(deck -> {
                    List<Cards> cardsToSetup = drawCardsFromDeck(updatePilePayload, deck);
                    Pile pile = updatePiles(deck, pileName, cardsToSetup);
                    deckRepository.save(deck);
                    return pile;
                });
    }

    private List<Cards> drawCardsFromDeck(UpdatePilePayload updatePilePayload, Deck deck) {
        if (updatePilePayload.numberOfCards() != null) {
            return drawNumberOfCards(deck, updatePilePayload.numberOfCards());
        }
        if (updatePilePayload.listOfCards() != null) {
            return drawSpecificCards(updatePilePayload.listOfCards(), deck);
        }
        return Collections.emptyList();
    }

    private List<Cards> drawNumberOfCards(Deck deck, Integer count) {
        List<Cards> cardsToDraw = new ArrayList<>();
        List<Cards> cards = deck.getCards();
        int deckSize = cards.size();
        for (int i = 0; i < count; i++) {
            Cards card = cards.get(deckSize - 1);
            cardsToDraw.add(card);
            cards.remove(card);
        }
        return cardsToDraw;
    }

    private List<Cards> drawSpecificCards(List<Cards> sourceListOfCard, Deck deck) {
        return null;
    }
// mozliwe rozbicie na metode aktualizujaca oraz tworzaca nowa pule
    private Pile updatePiles(Deck deck, String pileName, List<Cards> cardsToSetup) {
        List<Pile> listOfPiles = deck.getPile();
        return listOfPiles.stream()
                .filter(pile -> pile.getName().equals(pileName))
                .findFirst()
                .map(presentPile -> {
                    presentPile.getCards().addAll(cardsToSetup);
                    deck.getPile().set(listOfPiles.indexOf(presentPile), presentPile);
                    return presentPile;
                }).orElseGet(() -> {
                    Pile pile = pileService.createPile(pileName, cardsToSetup);
                    deck.getPile().add(pileService.createPile(pileName, cardsToSetup));
                    return pile;
                });
    }
}
