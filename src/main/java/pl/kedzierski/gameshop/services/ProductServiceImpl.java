package pl.kedzierski.gameshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kedzierski.gameshop.models.*;
import pl.kedzierski.gameshop.repositories.*;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private AvailabilityTypeRepository availabilityTypeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PlatformRepository platformRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<AvailabilityType> getAllAvailabilityTypes() {
        return availabilityTypeRepository.findAll();
    }

    @Override
    public List<Platform> getAllPlatforms() {
        return platformRepository.findAll();
    }

    @Override
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        Page page;
        page = productRepository.findAll(pageable);
        return page;
    }

    @Transactional
    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        //productRepository.deleteByid(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
