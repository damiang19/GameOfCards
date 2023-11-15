package pl.gamefactory.gameOfCard.unit;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.gamefactory.gameOfCard.GameOfCardApplication;
import pl.gamefactory.gameOfCard.services.DeckService;
import reactor.test.StepVerifier;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = GameOfCardApplication.class)
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
}
