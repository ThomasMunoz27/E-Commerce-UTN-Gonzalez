package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Prices;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.PricesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/prices")
public class PricesController extends BaseController<Prices> {
    public PricesController(PricesService pricesService) {
        super(pricesService);
    }
}
