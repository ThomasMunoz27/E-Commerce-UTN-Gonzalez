package com.ecommerce.ecommerce.payload;


import com.ecommerce.ecommerce.Entities.enums.Rol;

public class RegisterRequest {
    private String name;
    private String password;
    private Rol user;     // Podrías renombrar a `rol` para más claridad
    private String email;
    private String dni;
    private Long adressId;
    private Long sizeId;

    // Getters y Setters

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

    public Long getAdressId() {
        return adressId;
    }

    public Long getSizeId(){
        return sizeId;
    }

    public void setAdressId(Long adressId) {
        this.adressId = adressId;
    }
}