package pl.gamefactory.gameOfCard.resources;

import org.springframework.beans.factory.annotation.Autowired;
import pl.gamefactory.gameOfCard.repository.DeckRepository;
import pl.gamefactory.gameOfCard.entities.enums.Cards;
import org.springframework.web.bind.annotation.*;
import pl.gamefactory.gameOfCard.entities.Deck;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class DeckController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private  DeckRepository deckRepository;


    @GetMapping(value = "/decks")
    public List<Deck> getAllDecks() {
        LOG.info("Getting all decks ");
        return deckRepository.findAll();
    }
}
