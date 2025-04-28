package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Product;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/product")
public class ProductController extends BaseController<Product> {
    public ProductController(ProductService productService) {
        super(productService);
    }
}
