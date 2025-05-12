package com.ecommerce.ecommerce.Repositories;

import com.ecommerce.ecommerce.Entities.Category;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long>{
    Category findByName(String name);
}
