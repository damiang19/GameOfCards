package pl.gamefactory.gameOfCard.services;

import pl.gamefactory.gameOfCard.entities.Deck;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DeckService {
    Mono<Deck> generateDeck();
    Deck save(Deck deck);

}
