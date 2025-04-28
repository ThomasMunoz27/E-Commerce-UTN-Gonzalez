package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Discount;
import com.ecommerce.ecommerce.Repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService extends BaseService<Discount>{

    @Autowired
    private DiscountRepository discountRepository;


    public DiscountService(JpaRepository<Discount, Long> baseRepository) {
        super(baseRepository);
    }
}
