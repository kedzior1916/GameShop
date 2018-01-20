package pl.kedzierski.gameshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kedzierski.gameshop.models.Role;
import pl.kedzierski.gameshop.models.User;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByType(Role.Types type);
}
