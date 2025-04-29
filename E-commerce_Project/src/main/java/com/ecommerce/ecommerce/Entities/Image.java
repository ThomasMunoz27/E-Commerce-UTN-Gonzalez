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
}
