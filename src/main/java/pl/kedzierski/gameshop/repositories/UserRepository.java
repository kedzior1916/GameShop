package pl.kedzierski.gameshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kedzierski.gameshop.models.Product;
import pl.kedzierski.gameshop.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    User findByEmail(String name);
}
