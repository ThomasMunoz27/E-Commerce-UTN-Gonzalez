package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long>{

    @Query("SELECT p FROM Product p WHERE p.active = true")
    List<Product> findAllActive();
    @Query("SELECT p FROM Product p WHERE p.active = false")
    List<Product> findAllInactive();


    @Query("""
SELECT DISTINCT p FROM Product p
JOIN p.category c
WHERE p.active = true
AND (:categoriaId IS NULL OR c.id = :categoriaId)
""")
    Page<Product> findPagedByCategoriaId(@Param("categoriaId") Long categoriaId, Pageable pageable);


    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);

}
