package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Province;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.ProvinceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/province")
public class ProvinceController extends BaseController<Province>{

    public ProvinceController(ProvinceService provinceService) {
        super(provinceService);
    }
}
