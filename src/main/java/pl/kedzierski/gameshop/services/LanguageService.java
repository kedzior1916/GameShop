package pl.kedzierski.gameshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.kedzierski.gameshop.models.AvailabilityType;
import pl.kedzierski.gameshop.models.Language;

public interface LanguageService {

    Page<Language> getAllLanguages(Pageable pageable);

    Language getLanguage(Long id);

    void deleteLanguage(Long id);

    void saveLanguage(Language language);
}
