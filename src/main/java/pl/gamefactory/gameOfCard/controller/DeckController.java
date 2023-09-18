package pl.gamefactory.gameOfCard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.enums.Cards;
import pl.gamefactory.gameOfCard.repository.DeckRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/api")
public class DeckController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private  DeckRepository deckRepository;


//    @GetMapping(value = "/decks")
//    public List<Deck> getAllDecks() {
//        LOG.info("Getting all decks ");
//        return deckRepository.findAll();
//    }
//
    @PostMapping(value = "/decks")
    public Mono<Deck> createDeck(@RequestBody Deck deck) {
        LOG.info("New deck has been created {}", deck);
        deck.setCards(Arrays.stream(Cards.values()).toList());
        return deckRepository.insert(deck);
    }

    @GetMapping(value = "/first-stream")
    public Flux<String> stringStream() {
        return Flux.just("a","b","c","d");
    }

}
