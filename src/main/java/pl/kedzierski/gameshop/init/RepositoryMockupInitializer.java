package pl.kedzierski.gameshop.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import pl.kedzierski.gameshop.models.*;
import pl.kedzierski.gameshop.repositories.*;

@Configuration
public class RepositoryMockupInitializer implements InitializingBean {

    private AvailabilityTypeRepository availabilityTypeRepository;
    private ProductRepository productRepository;
    private PlatformRepository platformRepository;
    private LanguageRepository languageRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public RepositoryMockupInitializer(AvailabilityTypeRepository availabilityTypeRepository, ProductRepository productRepository, PlatformRepository platformRepository, LanguageRepository languageRepository, CategoryRepository categoryRepository) {
        this.availabilityTypeRepository = availabilityTypeRepository;
        this.productRepository = productRepository;
        this.platformRepository = platformRepository;
        this.languageRepository = languageRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void afterPropertiesSet(){
        initAvailabilityTypeRepository();
        initCategoryRepository();
        initLanguageRepository();
        initPlatformRepository();
    }

    public void initAvailabilityTypeRepository() {
        if(availabilityTypeRepository.findAll().isEmpty()){
            AvailabilityType a1 = new AvailabilityType();
            AvailabilityType a2 = new AvailabilityType();
            AvailabilityType a3 = new AvailabilityType();

            a1.setName("Dostępne 24h");
            a1.setInStock(true);
            availabilityTypeRepository.save(a1);

            a2.setName("Preorder");
            a2.setInStock(true);
            availabilityTypeRepository.save(a2);

            a3.setName("Brak w magazynie");
            a3.setInStock(false);
            availabilityTypeRepository.save(a3);
        }

    }
    public void initCategoryRepository() {
        if(categoryRepository.findAll().isEmpty()){
            Category c1 = new Category();
            Category c2 = new Category();
            Category c3 = new Category();

            c1.setName("Wyścigowa");
            categoryRepository.save(c1);

            c2.setName("Sportowa");
            categoryRepository.save(c2);

            c3.setName("Muzyczna");
            categoryRepository.save(c3);
        }
    }
    public void initPlatformRepository() {
        if(platformRepository.findAll().isEmpty()){
            Platform p1 = new Platform();
            Platform p2 = new Platform();
            Platform p3 = new Platform();

            p1.setName("PC");
            platformRepository.save(p1);

            p2.setName("PC Digital");
            platformRepository.save(p2);

            p3.setName("PS4");
            platformRepository.save(p3);
        }
    }
    public void initLanguageRepository(){
        if(languageRepository.findAll().isEmpty()){
            Language a1 = new Language();
            Language a2 = new Language();
            Language a3 = new Language();

            a1.setName("polski");
            languageRepository.save(a1);

            a2.setName("angielski");
            languageRepository.save(a2);

            a3.setName("japonski");
            languageRepository.save(a3);
        }
    }
}
