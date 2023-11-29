package pl.gamefactory.gameOfCard.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.gamefactory.gameOfCard.controller.DeckController;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.repository.DeckRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;



@ActiveProfiles("test")
@AutoConfigureDataMongo
@WebFluxTest(controllers = DeckController.class)
public class DeckControllerIT {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    DeckRepository deckRepository;

    @Test
    void generateDeck() {
        webTestClient.post().uri("/api/deck/create-new").exchange().expectStatus().isCreated();
        Flux<Deck> decks = deckRepository.findAll();
        StepVerifier.create(decks).expectNextCount(1).verifyComplete();
    }
}
