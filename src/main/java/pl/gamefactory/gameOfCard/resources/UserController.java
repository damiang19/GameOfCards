package pl.gamefactory.gameOfCard.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gamefactory.gameOfCard.entities.User;
import pl.gamefactory.gameOfCard.services.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Flux<User>> getAllUsers(){
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
       Mono<User> newUser = userService.save(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
