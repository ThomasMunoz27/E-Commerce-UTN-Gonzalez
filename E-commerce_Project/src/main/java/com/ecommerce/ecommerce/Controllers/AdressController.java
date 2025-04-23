package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Adress;
import com.ecommerce.ecommerce.Services.AdressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adress")
public class AdressController extends BaseController<Adress>{

    public AdressController(AdressService adressService){
        super(adressService);
    }
}
