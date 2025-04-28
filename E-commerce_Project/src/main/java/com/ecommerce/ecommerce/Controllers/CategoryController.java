package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Category;
import com.ecommerce.ecommerce.Repositories.CategoryRepository;
import com.ecommerce.ecommerce.Services.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends BaseController<Category> {
    public CategoryController(CategoryService categoryService){
        super(categoryService);
    }

}
