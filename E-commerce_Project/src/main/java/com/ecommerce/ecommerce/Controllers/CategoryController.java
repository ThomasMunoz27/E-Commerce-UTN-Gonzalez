package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Category;
import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Repositories.CategoryRepository;
import com.ecommerce.ecommerce.Services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
public class CategoryController extends BaseController<Category> {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super(categoryService);
        this.categoryService = categoryService;
    }

    @GetMapping("/search")
    public ResponseEntity<Category> searchByName(@RequestParam String name) {
        Category category = categoryService.findCategoryByName(name);
        if (category != null) {
            return ResponseEntity.ok(category);
        }else{
            return    ResponseEntity.notFound().build();
        }
    }
}
