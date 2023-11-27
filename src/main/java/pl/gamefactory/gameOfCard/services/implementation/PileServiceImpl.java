package pl.gamefactory.gameOfCard.services.implementation;

import org.springframework.stereotype.Service;
import pl.gamefactory.gameOfCard.dto.Cards;
import pl.gamefactory.gameOfCard.dto.UpdatePilePayload;
import pl.gamefactory.gameOfCard.entities.Pile;
import pl.gamefactory.gameOfCard.services.PileService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PileServiceImpl implements PileService {
    @Override
    public Mono<Pile> createPile(String pileName, List<Cards> cards) {
        return null;
    }

    @Override
    public Flux<Pile> updatePile(UpdatePilePayload updatePilePayload) {
        return null;
    }
}
