package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Prices;
import com.ecommerce.ecommerce.Repositories.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricesService extends BaseService<Prices>{

    @Autowired
    private PricesRepository pricesRepository;


    public PricesService(JpaRepository<Prices, Long> baseRepository) {
        super(baseRepository);
    }
}
