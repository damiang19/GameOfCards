package pl.gamefactory.gameOfCard.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import pl.gamefactory.gameOfCard.entities.enums.Cards;

import javax.persistence.*;
import java.util.List;

@Document("deck")
public class Deck {

    @Id
    private Long id;

    private String deckName;

    List<Cards> cards;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public List<Cards> getCards() {
        return cards;
    }
    public void setCards(List<Cards> cards) {
            this.cards = cards;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", deckName='" + deckName + '\'' +
                ", cards=" + cards +
                '}';
    }
}
