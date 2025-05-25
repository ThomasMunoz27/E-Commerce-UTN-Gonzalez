package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long>{

    @Query("SELECT p FROM Product p WHERE p.active = true")
    List<Product> findAllActive();

    @Query("""
SELECT p FROM Product p
WHERE p.active = true
AND (:categoria IS NULL OR LOWER(p.category.name) LIKE LOWER(CONCAT('%', :categoria, '%')))
""")
    List<Product> findAllByCategoria(@Param("categoria") String categoria);
}
