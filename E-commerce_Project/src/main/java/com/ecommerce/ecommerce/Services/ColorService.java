package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Color;
import com.ecommerce.ecommerce.Repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ColorService extends BaseService<Color>{
    @Autowired
    private ColorRepository colorRepository;

    public ColorService(JpaRepository<Color, Long> baseRepository) {
        super(baseRepository);
    }
}
