package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Province;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/province")
public class ProvinceController extends BaseController<Province>{

    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        super(provinceService);
        this.provinceService = provinceService;
    }

    @GetMapping("/by-country/{countryId}")
    public ResponseEntity<List<Province>> getProvincesByCountryId(@PathVariable Long countryId) {
        List<Province> provinces = provinceService.getProvincesByCountryId(countryId);
        return ResponseEntity.ok(provinces);
    }
}
