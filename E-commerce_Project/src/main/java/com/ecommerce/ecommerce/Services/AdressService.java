package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Adress;
import com.ecommerce.ecommerce.Repositories.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService extends BaseService<Adress>{

    @Autowired
    private AdressRepository adressRepository;

    public AdressService(JpaRepository<Adress, Long> baseRepository) {
        super(baseRepository);
    }
}
