package pl.gamefactory.gameOfCard.services;

import pl.gamefactory.gameOfCard.entities.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);
}
