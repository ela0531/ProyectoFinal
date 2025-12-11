/*
 * Universidad Autónoma de Santo Domingo
 * Facultad de Ciencias - Escuela de Informática
 * Proyecto Sakila CRUD
 * Autor: [Tu Nombre]
 * Fecha: 10/12/2025
 */
package com.sakila.models;

/**
 * Modelo de Cliente (Customer)
 */
public class Customer {
    private Integer id;
    private String name;
    private String phone;
    private String email;

    public Customer() {}

    public Customer(Integer id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
