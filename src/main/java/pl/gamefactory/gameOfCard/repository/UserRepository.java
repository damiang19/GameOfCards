package pl.gamefactory.gameOfCard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.gamefactory.gameOfCard.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);
}
