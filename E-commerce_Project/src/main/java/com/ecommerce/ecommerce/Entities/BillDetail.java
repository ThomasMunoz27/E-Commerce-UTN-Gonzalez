package com.ecommerce.ecommerce.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Detalle_factura")
public class BillDetail extends Base{

    @Column(name = "monto")
    private Double amount;
}
