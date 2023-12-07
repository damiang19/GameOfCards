package pl.gamefactory.gameOfCard.services;

import pl.gamefactory.gameOfCard.dto.UpdatePilePayload;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.Pile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DeckService {
    Mono<Deck> generateDeck();
    Deck save(Deck deck);
    Mono<Deck> getDeckById(String deckId);
    Mono<Pile> updateDeckPile(UpdatePilePayload updatePilePayload);
}
