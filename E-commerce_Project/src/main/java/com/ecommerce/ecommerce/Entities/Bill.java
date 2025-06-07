package com.ecommerce.ecommerce.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "descuento_total")
    private Double totalDiscount;

    @Column(name = "confirmada")
    private Double confirmed;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BillDetail> details;
}
