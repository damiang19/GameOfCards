package pl.gamefactory.gameOfCard.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import pl.gamefactory.gameOfCard.entities.enums.Cards;
import javax.persistence.*;
import java.util.List;

@Document("deck")
public class Deck {

    @Transient
    public static final String SEQUENCE_NAME = "deck_sequence";

    @Id
    private Long id;

    private List<Cards> cards;

    private List<Cards> cardsOnTable;

    public Deck(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cards> getCards() {
        return cards;
    }
    public void setCards(List<Cards> cards) {
            this.cards = cards;
    }

    public List<Cards> getCardsOnTable() {
        return cardsOnTable;
    }

    public void setCardsOnTable(List<Cards> cardsOnTable) {
        this.cardsOnTable = cardsOnTable;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", cards=" + cards +
                ", cardsOnTable=" + cardsOnTable +
                '}';
    }
}
