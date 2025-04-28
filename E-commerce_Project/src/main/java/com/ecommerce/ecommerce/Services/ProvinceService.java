package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Province;
import com.ecommerce.ecommerce.Repositories.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService extends BaseService<Province>{

    @Autowired
    private ProvinceRepository provinceRepository;


    public ProvinceService(JpaRepository<Province, Long> baseRepository) {
        super(baseRepository);
    }
}
