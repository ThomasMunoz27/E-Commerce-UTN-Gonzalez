package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Details;
import com.ecommerce.ecommerce.Services.DetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/details")
public class DetailsController extends BaseController<Details> {

    public DetailsController(DetailsService detailsService){
        super(detailsService);
    }
}
