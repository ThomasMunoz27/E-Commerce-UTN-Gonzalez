package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "Factura")
@Setter
@Getter
public class Bill extends Base{

    @Column(name = "total")
    private Double total;
    @Column(name = "fecha_compra")
    private LocalDate datePurchase;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;


}
