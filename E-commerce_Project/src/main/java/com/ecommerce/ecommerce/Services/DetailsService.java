package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Details;
import com.ecommerce.ecommerce.Repositories.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsService extends BaseService<Details>{

    @Autowired
    private DetailsRepository detailsRepository;


    public DetailsService(JpaRepository<Details, Long> baseRepository) {
        super(baseRepository);
    }
}
