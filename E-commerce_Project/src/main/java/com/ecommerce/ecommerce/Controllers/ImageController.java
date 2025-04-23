package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Image;
import com.ecommerce.ecommerce.Services.ImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image")
public class ImageController extends BaseController<Image>{

    public ImageController(ImageService imageService){
        super(imageService);
    }
}
