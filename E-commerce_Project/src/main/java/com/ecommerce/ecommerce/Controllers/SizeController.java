package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Size;
import com.ecommerce.ecommerce.Services.BaseService;

public class SizeController extends BaseController<Size> {

    public SizeController(BaseService<Size> baseService) {
        super(baseService);
    }
}
