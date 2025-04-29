package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


// Agregar @GetMapping()

@Entity
@Table(name = "Direccion")
@Setter
@Getter

public class Adress extends Base {

    @Column(name = "calle")
    private String street;
    @Column(name = "numero")
    private Integer number ;
    @Column(name = "codigo_postal")
    private Integer cp;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Locality locality;
}
