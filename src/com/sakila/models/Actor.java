/*
 * Universidad Autónoma de Santo Domingo
 * Facultad de Ciencias - Escuela de Informática
 * Proyecto Sakila CRUD
 * Autor: [Tu Nombre]
 * Fecha: 10/12/2025
 */
package com.sakila.models;

/**
 * Modelo de Actor
 */
public class Actor {
    private Integer id;
    private String name;

    public Actor() {}

    public Actor(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
