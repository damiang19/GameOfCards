package pl.gamefactory.gameOfCard.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import pl.gamefactory.gameOfCard.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      pl.gamefactory.gameOfCard.entities.User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authoritiesList = new ArrayList<>() ;
        authoritiesList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        if (user.getUsername().equals(username)) {
            return new User(username, user.getPassword(),
                    authoritiesList);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
