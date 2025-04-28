package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Province;
import com.ecommerce.ecommerce.Services.BaseService;

public class ProvinceController extends BaseController<Province>{

    public ProvinceController(BaseService<Province> baseService) {
        super(baseService);
    }
}
