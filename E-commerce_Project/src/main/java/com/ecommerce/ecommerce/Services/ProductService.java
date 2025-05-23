package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Product;
import com.ecommerce.ecommerce.Repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends BaseService<Product>{

    @Autowired
    private ProductRepository productRepository;


    public ProductService(JpaRepository<Product, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Product> optional = productRepository.findById(id);
            if (optional.isPresent()) {
                Product product = optional.get();
                product.setActive(false);
                productRepository.save(product);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Product> findAllActive() throws Exception {
        try {
            return productRepository.findAllActive();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Page<Product> findAllPaged(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
