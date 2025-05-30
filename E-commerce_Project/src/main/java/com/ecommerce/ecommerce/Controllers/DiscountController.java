package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Discount;
import com.ecommerce.ecommerce.Services.DiscountService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/discount")
public class DiscountController extends BaseController<Discount>{

    public DiscountController(DiscountService discountService){
        super(discountService);
    }
}
