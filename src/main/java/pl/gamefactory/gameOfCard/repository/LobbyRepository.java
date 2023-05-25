package pl.gamefactory.gameOfCard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.gamefactory.gameOfCard.entities.Lobby;

@Repository
public interface LobbyRepository extends MongoRepository<Lobby, Long> {
}
