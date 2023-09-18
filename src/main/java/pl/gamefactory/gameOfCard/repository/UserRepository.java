package pl.gamefactory.gameOfCard.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pl.gamefactory.gameOfCard.entities.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,Long> {
    User findByUsername(String username);
}
