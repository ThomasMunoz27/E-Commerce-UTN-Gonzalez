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

    //Datos de usuario no registrado
    @Column(name = "nombre_comprador")
    private String buyerName;

    @Column(name = "dni_comprador")
    private String buyerDni;

    @Column(name = "direccion_comprador")
    private String buyerAddress;

}
