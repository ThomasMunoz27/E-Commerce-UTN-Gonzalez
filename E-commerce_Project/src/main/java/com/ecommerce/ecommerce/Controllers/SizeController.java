package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Size;
import com.ecommerce.ecommerce.Services.SizeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/size")
public class SizeController extends BaseController<Size> {

    public SizeController(SizeService sizeService) {
        super(sizeService);
    }
}
