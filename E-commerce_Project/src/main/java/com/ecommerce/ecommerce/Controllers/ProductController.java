package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Product;
import com.ecommerce.ecommerce.Services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductController extends BaseController<Product> {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        super(productService);
        this.productService = productService;
    }

    @GetMapping("/active")
    public ResponseEntity<List<Product>> getAllActive() throws Exception{
        return ResponseEntity.ok(productService.findAllActive());
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<Product>> getAllInactive() throws Exception{
        return ResponseEntity.ok(productService.findAllInactive());
    }

    @GetMapping("/paged")
    public Page<Product> getPagedProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        if (categoryId == null) {
            return productService.findAllPaged(pageable); // sin filtro
        } else {
            return productService.findPagedAndFiltered(categoryId, pageable); // con filtro
        }}}