package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Locality;
import com.ecommerce.ecommerce.Entities.Province;
import com.ecommerce.ecommerce.Repositories.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityService extends BaseService<Locality>{

    @Autowired
    private LocalityRepository localityRepository;


    public LocalityService(JpaRepository<Locality, Long> baseRepository) {
        super(baseRepository);
    }

    public List<Locality> getLocalitiesByProvinceId(Long provinceId){
        return localityRepository.findByProvinceId(provinceId);
    }
}
