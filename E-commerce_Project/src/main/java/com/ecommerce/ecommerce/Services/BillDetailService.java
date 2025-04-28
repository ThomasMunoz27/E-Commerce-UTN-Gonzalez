package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.BillDetail;
import com.ecommerce.ecommerce.Repositories.BillDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BillDetailService extends BaseService<BillDetail> {

    @Autowired
    private BillDetailRepository billDetailRepository;

    public BillDetailService(JpaRepository<BillDetail, Long> baseRepository) {
        super(baseRepository);
    }
}

