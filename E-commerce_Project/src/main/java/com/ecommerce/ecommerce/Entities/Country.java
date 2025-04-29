package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Pais")
@Setter
@Getter
public class Country extends Base {

    @Column(name = "nombre")
    private String name;
}
