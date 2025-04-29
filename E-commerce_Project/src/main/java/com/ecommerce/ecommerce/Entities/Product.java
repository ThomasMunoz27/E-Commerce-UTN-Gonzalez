package com.ecommerce.ecommerce.Entities;

import com.ecommerce.ecommerce.Entities.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Productos")
@Setter
@Getter

public class Product extends Base {

    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Category Category;
    @Column(name = "tipo_producto")
    private ProductType productType;
    @Column(name = "sexo")
    private String sex;
}
