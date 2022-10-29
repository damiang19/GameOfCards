package pl.gamefactory.gameOfCard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.gamefactory.gameOfCard.entities.Deck;

@Repository
public interface DeckRepository extends MongoRepository<Deck,Long> {
}
