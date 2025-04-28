package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Prices;
import com.ecommerce.ecommerce.Services.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/prices")
public class PricesController extends BaseController<Prices> {
    public PricesController(BaseService<Prices> baseService) {
        super(baseService);
    }
}
