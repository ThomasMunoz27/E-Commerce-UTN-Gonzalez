package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Country;
import com.ecommerce.ecommerce.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService extends BaseService<Country>{
    @Autowired
    private CountryRepository countryRepository;


    public CountryService(JpaRepository<Country, Long> baseRepository) {
        super(baseRepository);
    }
}
