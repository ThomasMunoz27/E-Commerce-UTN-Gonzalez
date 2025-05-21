package com.ecommerce.ecommerce.Entities;

import com.ecommerce.ecommerce.Entities.enums.Rol;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Usuarios")
@Setter
@Getter
public class User extends Base {

    @Column(name = "nombre")
    private String name ;
    @Column(name = "constraseña")
    private String password;
    @Column(name = "usuario")
    private Rol user;
    @Column(name = "email")
    private String email;
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombre_usuario")
    private String username;
    @Column(name = "fecha_nacimiento")
    private Date birthdate;
    @Column(name = "apellido")
    private String lastname;
    @Column(name = "numero_telefonico")
    private Integer phoneNumber;


    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Adress adress;

    @ManyToOne
    @JoinColumn(name = "talla_id")
    private Size size;


    // Getter para 'name'
    public String getName() {
        return name;
    }

    // Setter para 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter para 'password'
    public String getPassword() {
        return password;
    }

    // Setter para 'password'
    public void setPassword(String password) {
        this.password = password;
    }

}