package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Categoria")
@Setter
@Getter
public class Category extends Base {
    @Column(name = "nombre")
    private String name;
}
