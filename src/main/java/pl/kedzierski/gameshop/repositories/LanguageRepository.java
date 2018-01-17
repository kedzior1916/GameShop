package pl.kedzierski.gameshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.kedzierski.gameshop.models.Language;
import pl.kedzierski.gameshop.models.Product;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    Page<Product> findByNameContaining(String phrase, Pageable pageable);
}
