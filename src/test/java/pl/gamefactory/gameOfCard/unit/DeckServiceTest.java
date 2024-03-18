package pl.gamefactory.gameOfCard.unit;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.ActiveProfiles;
import pl.gamefactory.gameOfCard.services.DeckService;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@AutoConfigureDataMongo
@WebFluxTest
public class DeckServiceTest {

    @Autowired
    private  DeckService deckService;

    @Test
    void test(){
        // GIVEN
        var mono = deckService.generateDeck();
        // WHEN + THEN
        StepVerifier.create(mono).assertNext(deck -> {
            assertThat(deck.getCards()).hasSize(52);
            assertThat(deck.getRemainingCards()).isEqualTo(52);
            assertThat(deck.getId()).isNotEqualTo(null);
        }).verifyComplete();
    }


    private LocalDateTime successfulDateFetching() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("GETTING DATE");
        return LocalDateTime.now();
    }

    private Mono<String> monoJust()  {
       return Mono.defer(() -> {
         return  "ww";
       });
    }
    @Test
    void checkMono() throws InterruptedException {
        var myMono = monoJust();
        System.out.println(myMono);
        myMono.subscribe(System.out::println);
        myMono.subscribe(System.out::println);
        myMono.subscribe(System.out::println);        // GIVEN
        // WHEN + THEN
    }


}
