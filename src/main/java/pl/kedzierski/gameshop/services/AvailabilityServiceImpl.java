package pl.kedzierski.gameshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kedzierski.gameshop.exceptions.ItemNotFoundException;
import pl.kedzierski.gameshop.models.AvailabilityType;
import pl.kedzierski.gameshop.models.Category;
import pl.kedzierski.gameshop.models.Product;
import pl.kedzierski.gameshop.repositories.AvailabilityTypeRepository;

import java.util.Optional;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityTypeRepository availabilityTypeRepository;

    @Override
    public Page<AvailabilityType> getAllTypes(Pageable pageable) {
        Page page = availabilityTypeRepository.findAll(pageable);
        return page;
    }

    @Transactional
    @Override
    public AvailabilityType getType(Long id) {
        Optional<AvailabilityType> optionalType = availabilityTypeRepository.findById(id);
        AvailabilityType type = optionalType.orElseThrow(()->new ItemNotFoundException(id));
        return type;
    }

    @Override
    public void deleteType(Long id) {
        availabilityTypeRepository.deleteById(id);
    }

    @Override
    public void saveType(AvailabilityType type) {
        availabilityTypeRepository.save(type);
    }
}
