package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Talla")
@Setter
@Getter
public class Size extends Base{
    @Column(name = "talla")
    private String size;
}
