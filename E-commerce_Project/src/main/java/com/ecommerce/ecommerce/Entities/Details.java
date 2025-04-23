package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Detalles")


public class Details extends Base{

    @Column(name = "tamaño")
    private String size;
    @Column(name = "stock")
    private  Integer stock;
    @Column(name = "color")
    private String color ;
    @Column(name = "estado")
    private Boolean state;

    @OneToOne
    @JoinColumn(name = "precio_id")
    private Prices prices;

    @OneToMany
    @JoinColumn(name = "imagen_id")
    private Image image;
}
