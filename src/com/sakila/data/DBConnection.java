/*
 * Universidad Autónoma de Santo Domingo
 * Facultad de Ciencias - Escuela de Informática
 * Proyecto Sakila CRUD
 * Autor: YINET VALDEZ IBERT
 * Matricula: 100597131
 * Fecha: 10/12/2025
 */
package com.sakila.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

/**
 * Clase para gestionar la conexión a MySQL usando archivo de propiedades externo.
 */
public class DBConnection {
    private static String url;
    private static String user;
    private static String password;
    private static boolean loaded = false;

    private static void loadProperties() {
        if (loaded) return;
        Properties props = new Properties();
        try (InputStream input = DBConnection.class.getResourceAsStream("/com/sakila/data/db.properties")) {
            if (input == null) {
                throw new IOException("No se encontró el archivo db.properties");
            }
            props.load(input);
            url = props.getProperty("mysql.url");
            user = props.getProperty("mysql.user");
            password = props.getProperty("mysql.password");
            loaded = true;
        } catch (IOException e) {
            throw new RuntimeException("Error cargando configuración de base de datos", e);
        }
    }

    /**
     * Obtiene una conexión a la base de datos MySQL.
     * @return Connection
     * @throws SQLException si ocurre un error de conexión
     */
    public static Connection getConnection() throws SQLException {
        loadProperties();
        return DriverManager.getConnection(url, user, password);
    }
}
