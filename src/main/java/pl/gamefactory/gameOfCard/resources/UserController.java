package pl.gamefactory.gameOfCard.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gamefactory.gameOfCard.entities.User;
import pl.gamefactory.gameOfCard.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
       User newUser = userService.save(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
