package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Precios")
@Setter
@Getter
public class Prices extends Base {

    @Column(name = "precio_compra")
    private Double purchasePrice;
    @Column(name = "precio_venta")
    private Double salePrice;

    @ManyToOne
    @JoinColumn(name = "descuento_id")
    private Discount discount;

}
