package com.ecommerce.ecommerce.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Colores")
@Getter
@Setter
public class Color extends Base{

    @Column(name = "nombre")
    private String name;
}
