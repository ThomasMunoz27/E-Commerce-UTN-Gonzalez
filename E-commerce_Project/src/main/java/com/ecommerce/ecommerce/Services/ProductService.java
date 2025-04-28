package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Product;
import com.ecommerce.ecommerce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<Product>{

    @Autowired
    private ProductRepository productRepository;


    public ProductService(JpaRepository<Product, Long> baseRepository) {
        super(baseRepository);
    }
}
