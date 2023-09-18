package pl.gamefactory.gameOfCard.services.implementation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.gamefactory.gameOfCard.entities.User;
import pl.gamefactory.gameOfCard.repository.UserRepository;
import pl.gamefactory.gameOfCard.services.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Flux<User> findAll() {
        logger.info("Get all users");
        return userRepository.findAll();
    }
    @Override
    public Mono<User> save(User user){
        logger.info("Creating new user");
        return userRepository.save(user);
    }
}
