package com.ecommerce.ecommerce.Entities;

import com.ecommerce.ecommerce.Entities.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "Productos")
@Setter
@Getter

public class Product extends Base {

    @Column(name = "nombre")
    private String name;

    // Para que un producto tenga varias categorias
    @ManyToMany
    @JoinTable(
            name = "producto_categoria",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<Category> category;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_producto")
    private ProductType productType;
    @Column(name = "sexo")
    private String sex;

    @OneToOne
    @JoinColumn(name = "precio_id")
    private Prices prices;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Image image;

    @ManyToMany
    @JoinTable(
            name = "producto_talle",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_talle")
    )
    private List<Size> sizes; 

    @ManyToMany
    @JoinTable(
            name = "producto_color",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_color")
    )
    private List<Color> colors;

    @Column(name = "stock")
    private  Integer stock;

    @Column(name = "descripcion")
    private String description;

    public void setActive(Boolean active) {
        this.active = active;
    }


    @Column(name = "activo")
    private Boolean active = true;
}
