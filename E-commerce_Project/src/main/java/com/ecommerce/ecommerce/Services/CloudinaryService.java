package com.ecommerce.ecommerce.Services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ecommerce.ecommerce.Entities.Image;
import com.ecommerce.ecommerce.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ImageRepository imageRepository;

    public Image uploadFile(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap("folder", "mi carpeta"));

        String url = uploadResult.get("secure_url").toString();
        String publicId = uploadResult.get("public_id").toString();

        Image image = new Image();
        image.setUrl(url);
        image.setPublicId(publicId);

        return imageRepository.save(image);
    }

    public Image updateImage(Long id , MultipartFile file) throws IOException {
        Image existingImage = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));

        // Eliminar imagen anterior
        if (existingImage.getPublicId() != null) {
            cloudinary.uploader().destroy(existingImage.getPublicId(), ObjectUtils.emptyMap());
        }

        // Subir nueva Imagen
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap("folder", "mi carpeta"));

        //Actualizar datos
        existingImage.setUrl(uploadResult.get("secure_url").toString());
        existingImage.setPublicId(uploadResult.get("public_id").toString());

        return imageRepository.save(existingImage);
    }

}
