package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Bill;
import com.ecommerce.ecommerce.Repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService extends BaseService<Bill>{
    @Autowired
    private BillRepository billRepository;


    public BillService(JpaRepository<Bill, Long> baseRepository) {
        super(baseRepository);
    }
}
