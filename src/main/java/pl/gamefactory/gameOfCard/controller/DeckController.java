package pl.gamefactory.gameOfCard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.enums.Cards;
import pl.gamefactory.gameOfCard.repository.DeckRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/api")
public class DeckController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private DeckRepository deckRepository;


    //    @GetMapping(value = "/decks")
//    public List<Deck> getAllDecks() {
//        LOG.info("Getting all decks ");
//        return deckRepository.findAll();
//    }
//
    @PostMapping(value = "/deck/create-new")
    public ResponseEntity<Mono<Deck>> createDeck(@RequestBody String d) {
//        LOG.info("New deck has been created {}", deck);
        Mono<Deck> deck =  deckRepository.save(Deck.builder()
                .cards(Arrays.stream(Cards.values()).toList())
                .pile(new ArrayList<>())
                .build());
        return ResponseEntity.status(HttpStatus.CREATED).body(deck);
    }

    @GetMapping(value = "/first-stream")
    public Flux<String> stringStream() {
        return Flux.just("a", "b", "c", "d");
    }

}
