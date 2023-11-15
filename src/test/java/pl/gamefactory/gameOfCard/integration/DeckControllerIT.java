package pl.gamefactory.gameOfCard.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.gamefactory.gameOfCard.GameOfCardApplication;
import pl.gamefactory.gameOfCard.controller.DeckController;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.repository.DeckRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.*;


@ActiveProfiles("test")
@AutoConfigureDataMongo
@ExtendWith(SpringExtension.class)
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
