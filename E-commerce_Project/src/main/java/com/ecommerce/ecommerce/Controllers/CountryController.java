package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Country;
import com.ecommerce.ecommerce.Services.CountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/country")
public class CountryController extends BaseController<Country>{

    public CountryController(CountryService countryService){
        super(countryService);
    }
}
