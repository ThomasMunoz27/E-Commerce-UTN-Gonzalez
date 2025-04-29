package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Provincia")
@Setter
@Getter

public class Province extends Base {

    @Column(name = "nombre")
    private String name ;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Country country;

}
