package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.Image;
import com.ecommerce.ecommerce.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService extends BaseService<Image>{

    @Autowired
    private ImageRepository imageRepository;


    public ImageService(JpaRepository<Image, Long> baseRepository) {
        super(baseRepository);
    }
}
