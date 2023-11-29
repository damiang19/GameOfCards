package pl.gamefactory.gameOfCard.unit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.ActiveProfiles;
import pl.gamefactory.gameOfCard.services.PileService;

@ActiveProfiles("test")
@AutoConfigureDataMongo
@WebFluxTest
public class PileServiceTest {

    @Autowired
    PileService pileService;

    @Test
    void test() {

    }
}
