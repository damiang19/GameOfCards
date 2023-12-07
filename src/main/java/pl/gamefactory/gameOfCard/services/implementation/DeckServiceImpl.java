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
import java.util.List;
import java.util.Optional;

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
    public Deck save(Deck deck) {
        return null;
    }

    @Override
    public Mono<Deck> getDeckById(String deckId) {
        log.debug("Request to get deck with id : {}", deckId);
        return deckRepository.findById(deckId);
    }

    private List<Cards> drawNumberOfCards(List<Cards> cards, Integer count) {
        List<Cards> cardsToDraw = new ArrayList<>();
        int deckSize = cards.size();
        for (int i = 0; i < count; i++) {
            Cards card = cards.get(deckSize - 1);
            cardsToDraw.add(card);
            cards.remove(card);
        }
        return cardsToDraw;
    }

    private List<Cards> drawSpecificCards(List<Cards> sourceListOfCard, List<Cards> destinationListOfCard) {
        return null;
    }

    private Pile updatePiles(Deck deck, String pileName, List<Cards> cardsToSetup) {
        List<Pile> listOfPiles = deck.getPile();
        return listOfPiles.stream()
                .filter(pile -> pile.getName().equals(pileName))
                .findFirst()
                .map(presentPile -> {
                    int pileIndex = listOfPiles.indexOf(presentPile);
                    presentPile.getCards().addAll(cardsToSetup);
                    deck.getPile().set(pileIndex, presentPile);
                    return presentPile;
                }).orElseGet(() -> {
                    Pile pile = pileService.createPile(pileName, cardsToSetup);
                    deck.getPile().add(pileService.createPile(pileName, cardsToSetup));
                    return pile;
                });
    }

    @Override
    public void updateDeckPile(UpdatePilePayload updatePilePayload) {
        getDeckById(updatePilePayload.deckId()).subscribe(deck -> {
            List<Cards> cards = deck.getCards();
            if (updatePilePayload.numberOfCards() != null) {
                List<Cards> cardsToSetup = drawNumberOfCards(cards, updatePilePayload.numberOfCards());

            }
            deckRepository.save(deck);
        });
    }
}
