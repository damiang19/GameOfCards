package pl.gamefactory.gameOfCard.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import pl.gamefactory.gameOfCard.entities.enums.GameType;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Document("lobby")
public class Lobby {

    @Transient
    public static final String SEQUENCE_NAME = "lobby_sequence";

    @Id
    private Long id;

    private String lobbyName;

    private GameType gameType;

    private List<User> players;

    private Boolean isEnabled;

    private Long gameTime;


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

    public Long getGameTime() {
        return gameTime;
    }

    public void setGameTime(Long gameTime) {
        this.gameTime = gameTime;
    }

    @Override
    public String toString() {
        return "Lobby{" +
                "id=" + id +
                ", lobbyName='" + lobbyName + '\'' +
                ", gameType=" + gameType +
                ", players=" + players +
                ", isEnabled=" + isEnabled +
                ", gameTime=" + gameTime +
                '}';
    }
}

