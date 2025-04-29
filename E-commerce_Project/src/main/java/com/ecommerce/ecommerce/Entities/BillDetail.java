package com.ecommerce.ecommerce.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Detalle_factura")
@Setter
@Getter
public class BillDetail extends Base{

    @Column(name = "monto")
    private Double amount;
}
