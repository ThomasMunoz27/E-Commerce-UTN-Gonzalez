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
//comentario para mergin
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
    @Column (name = "sexo")
    private String sex;


    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Adress adress;

    @ManyToOne
    @JoinColumn(name = "talla_id")
    private Size size;

    @Column(name = "activo")
    private Boolean active = true;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getUser() {
        return user;
    }

    public void setUser(Rol user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


}