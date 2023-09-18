package pl.gamefactory.gameOfCard.services;

import pl.gamefactory.gameOfCard.entities.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {
    Flux<User> findAll();

    Mono<User> save(User user);
}
