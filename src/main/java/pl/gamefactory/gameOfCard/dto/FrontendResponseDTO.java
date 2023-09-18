package pl.gamefactory.gameOfCard.dto;

import pl.gamefactory.gameOfCard.entities.Deck;
import pl.gamefactory.gameOfCard.entities.Lobby;
import pl.gamefactory.gameOfCard.entities.User;

public class FrontendResponseDTO {

    private Deck deck;

    private User user;

    private Lobby lobby;

    FrontendResponseDTO(){}

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lobby getLobby() {
        return lobby;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    @Override
    public String toString() {
        return "FrontendResponseDTO{" +
                "deck=" + deck +
                ", user=" + user +
                ", lobby=" + lobby +
                '}';
    }
}
