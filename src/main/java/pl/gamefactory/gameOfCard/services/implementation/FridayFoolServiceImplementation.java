package pl.gamefactory.gameOfCard.services.implementation;

import org.springframework.stereotype.Service;
import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.User;
import pl.gamefactory.gameOfCard.entities.enums.Cards;
import pl.gamefactory.gameOfCard.services.DeckService;
import pl.gamefactory.gameOfCard.services.FridayFoolService;
import pl.gamefactory.gameOfCard.services.UserService;
import pl.gamefactory.gameOfCard.utils.SecurityUtils;

import java.util.List;

@Service
public class FridayFoolServiceImplementation implements FridayFoolService {

    private final UserService userService;
    private final DeckService deckService;

    private final int DEFAULT_HAND_SIZE = 5;

    public FridayFoolServiceImplementation(UserService userService, DeckService deckService) {
        this.userService = userService;
        this.deckService = deckService;
    }

    @Override
    public List<Cards> getCardsAndUpdateDeck(Deck deck) {
        User user = userService.findByUsername(SecurityUtils.getCurrentUserLogin().get());
        user.setCards(updateUserHand(user.getCards(), deck));
        return userService.save(user)
                .getCards();
    }

    @Override
    public List<Cards> updateUserHand(List<Cards> userCards, Deck deck) {
        // TODO  : karty powinny byc usuwane z decku po pobraniu
        int cardsInDeck = deck.getCards().size();

        if (userCards.size() < DEFAULT_HAND_SIZE && cardsInDeck > 0) {
            int cardsToGet = DEFAULT_HAND_SIZE - userCards.size();

            if (cardsInDeck >= cardsToGet) {
                for (int i = 0; i < cardsToGet; i++) {
                    cardsInDeck = deck.getCards().size();
                    userCards.add(deck.getCards().get(cardsInDeck - 1));
                }
                // jezeli w decku jest mniej kart niz potrzebujemy
                if (cardsInDeck < cardsToGet) {
                    for (Cards card : deck.getCards()) {
                        userCards.add(card);
                        deck.getCards().remove(card);
                    }
                }

            }
            deckService.save(deck);
        }
        return userCards;
    }
}
