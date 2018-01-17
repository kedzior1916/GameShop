package pl.kedzierski.gameshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.kedzierski.gameshop.models.Platform;
import pl.kedzierski.gameshop.models.Product;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

    Page<Product> findByNameContaining(String phrase, Pageable pageable);
}
