package pl.kedzierski.gameshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kedzierski.gameshop.exceptions.ItemNotFoundException;
import pl.kedzierski.gameshop.models.AvailabilityType;
import pl.kedzierski.gameshop.models.Language;
import pl.kedzierski.gameshop.repositories.AvailabilityTypeRepository;
import pl.kedzierski.gameshop.repositories.LanguageRepository;

import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Page<Language> getAllLanguages(Pageable pageable) {
        Page page = languageRepository.findAll(pageable);
        return page;
    }

    @Transactional
    @Override
    public Language getLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        Language language = optionalLanguage.orElseThrow(()->new ItemNotFoundException(id));
        return language;
    }

    @Override
    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }

    @Override
    public void saveLanguage(Language language) {
        languageRepository.save(language);
    }
}
