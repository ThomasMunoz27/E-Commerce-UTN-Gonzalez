package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Color;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.ColorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/color")
public class ColorController extends BaseController<Color>{

    public ColorController(ColorService colorService) {
        super(colorService);
    }
}
