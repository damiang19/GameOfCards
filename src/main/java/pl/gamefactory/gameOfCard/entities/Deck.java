package pl.gamefactory.gameOfCard.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import pl.gamefactory.gameOfCard.entities.enums.Cards;

import java.util.List;

@Document("deck")
public class Deck {


    private Long id;

    private List<Cards> cards;

    private List<Cards> pile;


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

    public List<Cards> getPile() {
        return pile;
    }

    public void setPile(List<Cards> pile) {
        this.pile = pile;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", cards=" + cards +
                ", pile=" + pile +
                '}';
    }
}
