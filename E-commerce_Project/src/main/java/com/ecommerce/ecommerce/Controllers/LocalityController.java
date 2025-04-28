
package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Locality;
import com.ecommerce.ecommerce.Services.LocalityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/locality")
public class LocalityController extends BaseController<Locality>{

    public LocalityController(LocalityService localityService){
        super(localityService);
    }
}
