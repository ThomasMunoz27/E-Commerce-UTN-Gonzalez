
package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Locality;
import com.ecommerce.ecommerce.Entities.Province;
import com.ecommerce.ecommerce.Services.LocalityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/locality")
public class LocalityController extends BaseController<Locality>{

    private final LocalityService localityService;

    public LocalityController(LocalityService localityService){
        super(localityService);
        this.localityService = localityService;
    }

    @GetMapping("/by-province/{provinceId}")
    public ResponseEntity<List<Locality>> getLocalitiesByProvinceId(@PathVariable Long provinceId) {
        List<Locality> localities = localityService.getLocalitiesByProvinceId(provinceId);
        return ResponseEntity.ok(localities);
    }
}
