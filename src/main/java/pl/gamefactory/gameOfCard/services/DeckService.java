package pl.gamefactory.gameOfCard.services;

import pl.gamefactory.gameOfCard.entities.Deck;

import java.util.List;

public interface DeckService {
    Deck createDeck();
    Deck save(Deck deck);



}
