package pl.kedzierski.gameshop.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.kedzierski.gameshop.models.User;

public interface UserService extends UserDetailsService{
    void save(User user);

    boolean isUniqueLogin(String login);
}
