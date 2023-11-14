package pl.gamefactory.gameOfCard.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.gamefactory.gameOfCard.GameOfCardApplication;
import pl.gamefactory.gameOfCard.controller.DeckController;

@ActiveProfiles("test")
@AutoConfigureDataMongo
@WebFluxTest(controllers = DeckController.class)
public class DeckControllerIT {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void generateDeck() {
        webTestClient.post().uri("/api/deck/create-new").exchange().expectStatus().isCreated();
    }
}
