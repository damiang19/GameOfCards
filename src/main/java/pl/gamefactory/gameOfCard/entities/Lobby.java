package pl.gamefactory.gameOfCard.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import pl.gamefactory.gameOfCard.entities.enums.GameType;

import java.util.List;

@Document("lobby")
public class Lobby {


    private Long id;

    private String lobbyName;

    private GameType gameType;

    private Long deckId;

    private List<User> players;

    private Boolean isEnabled;

    private Long timeToEnd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Long getTimeToEnd() {
        return timeToEnd;
    }

    public void setTimeToEnd(Long timeToEnd) {
        this.timeToEnd = timeToEnd;
    }

    @Override
    public String toString() {
        return "Lobby{" +
                "id=" + id +
                ", lobbyName='" + lobbyName + '\'' +
                ", gameType=" + gameType +
                ", deckId=" + deckId +
                ", players=" + players +
                ", isEnabled=" + isEnabled +
                ", timeToEnd=" + timeToEnd +
                '}';
    }
}

