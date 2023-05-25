package pl.gamefactory.gameOfCard.services;


import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.enums.Cards;

import java.util.List;

public interface FridayFoolService {
    List<Cards> getCardsAndUpdateDeck(Deck deck);

    List<Cards> updateUserHand(List<Cards> list, Deck deck);
}
