package pl.gamefactory.gameOfCard.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pl.gamefactory.gameOfCard.entities.Deck;

@Repository
public interface DeckRepository extends ReactiveMongoRepository<Deck,String> {

}
