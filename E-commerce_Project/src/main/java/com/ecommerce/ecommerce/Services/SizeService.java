package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Size;
import com.ecommerce.ecommerce.Repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class SizeService extends BaseService<Size> {

    @Autowired
    private SizeRepository sizeRepository;


    public SizeService(JpaRepository<Size, Long> baseRepository) {
        super(baseRepository);
    }
}
