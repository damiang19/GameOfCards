package pl.gamefactory.gameOfCard.dto;

import pl.gamefactory.gameOfCard.enums.CardColor;
import pl.gamefactory.gameOfCard.enums.CardValue;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Cards {

    private CardValue cardValue;
    private CardColor cardColor;

    private Cards(CardValue cardValue, CardColor cardColor) {
        this.cardValue = cardValue;
        this.cardColor = cardColor;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public static List<Cards> generateDeck() {
        List<Cards> cards = new ArrayList<>();
        for (CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                cards.add(new Cards(value, color));
            }
        }
        Collections.shuffle(cards);
        return cards;
    }
}
