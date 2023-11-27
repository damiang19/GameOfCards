package pl.gamefactory.gameOfCard.services;

import pl.gamefactory.gameOfCard.dto.Cards;
import pl.gamefactory.gameOfCard.dto.UpdatePilePayload;
import pl.gamefactory.gameOfCard.entities.Pile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PileService {
    Mono<Pile> createPile(String pileName, List<Cards> cards);

    Flux<Pile> updatePile(UpdatePilePayload updatePilePayload);
}
