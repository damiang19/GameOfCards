package pl.gamefactory.gameOfCard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.services.DeckService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api")
public class DeckController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }


// Rozpiska endpointow :
    // Utworzenie decku -

    // 1. Dobranie kart z decku
    // 2. Przetasowanie kart
    // 3. Sprawdzenie ilosci kart

    // 4. Sprawdzenie kart w poli
    // 5. Wydanie kart z jednej poli do drugiej
    // 6. Przetasowanie poli
    // 7. Dobranie kart z poli

    @PostMapping(value = "/deck/create-new")
    public ResponseEntity<Mono<Deck>> createDeck() {
        log.debug("REST request to generate new deck");
        Mono<Deck> deck = deckService.generateDeck();
        return ResponseEntity.status(HttpStatus.CREATED).body(deck);
    }



}
