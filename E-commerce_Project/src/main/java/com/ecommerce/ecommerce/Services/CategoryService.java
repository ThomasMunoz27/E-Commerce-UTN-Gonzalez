package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Category;
import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends BaseService<Category>{
    @Autowired
    private  CategoryRepository categoryRepository;


    public CategoryService(JpaRepository<Category, Long> baseRepository) {
        super(baseRepository);
    }
    public  List<Category> findCategoryByName(String name){
        return categoryRepository.findByName(name);
    }
}
