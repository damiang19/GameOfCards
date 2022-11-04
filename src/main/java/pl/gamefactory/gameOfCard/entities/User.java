package pl.gamefactory.gameOfCard.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import pl.gamefactory.gameOfCard.entities.enums.Cards;
import javax.persistence.*;
import java.util.List;


@Document("uzytkownik")
public class User {

    @Id
    private String id;

    private String username;

    private String password;

    private List<Cards> cards;

    private Long timeLeft;
    private Long deckId;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }

    public Long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }

    public Long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Long timeLeft) {
        this.timeLeft = timeLeft;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cards=" + cards +
                ", deckId=" + deckId +
                '}';
    }
}
