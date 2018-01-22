package pl.kedzierski.gameshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kedzierski.gameshop.exceptions.ItemNotFoundException;
import pl.kedzierski.gameshop.models.Platform;
import pl.kedzierski.gameshop.models.Product;
import pl.kedzierski.gameshop.repositories.PlatformRepository;
import pl.kedzierski.gameshop.repositories.ProductRepository;
import pl.kedzierski.gameshop.services.PlatformService;

import java.util.Optional;

@Service
public class PlatformServiceImpl implements PlatformService {
    
    @Autowired
    private PlatformRepository platformRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProductsbyPlatform(Long id, Pageable pageable) {
        Page page = productRepository.findAllProductsByPlatform(id, pageable);
        return page;
    }

    @Override
    public Page<Platform> getAllPlatforms(Pageable pageable) {
        Page page = platformRepository.findAll(pageable);
        return page;
    }

    @Transactional
    @Override
    public Platform getPlatform(Long id) {
        Optional<Platform> optionalPlatform = platformRepository.findById(id);
        Platform platform = optionalPlatform.orElseThrow(()->new ItemNotFoundException(id));
        return platform;
    }

    @Override
    public void deletePlatform(Long id) {
        platformRepository.deleteById(id);
    }

    @Override
    public void savePlatform(Platform platform) {
        platformRepository.save(platform);
    }
}
