package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Talla")
public class Size extends Base{

    @Column(name = "talla")
    private String size;
}
