package com.ecommerce.ecommerce.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Detalle_factura")
@Setter
@Getter
public class BillDetail extends Base{

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product product;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "precio_unitario")
    private Double unitPrice;

    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    @JsonBackReference
    private Bill bill;
}
