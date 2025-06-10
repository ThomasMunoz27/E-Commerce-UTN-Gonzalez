package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Imagenes")
@Setter
@Getter


public class Image extends Base {

    @Column(name = "url")
    private String url;

    @Column(name = "public_id")
    private String publicId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }
}
