/*
 * Universidad Autónoma de Santo Domingo
 * Facultad de Ciencias - Escuela de Informática
 * Proyecto Sakila CRUD
 * Autor: YINET VALDEZ IBERT
 * Matricula: 100597131
 * Fecha: 10/12/2025
 */
package com.sakila.data;

import java.util.*;

/**
 * Clase abstracta híbrida para gestión de datos.
 * Métodos concretos no sobreescribibles por hijos.
 * @param <T> Tipo de entidad
 * @param <K> Tipo de clave primaria
 */
public abstract class DataContext<T, K> implements iDatapost<T, K> {
    protected Map<K, T> dataStore = new HashMap<>();
    protected int autoIncrement = 1;

    @Override
    public final T get(K id) {
        return dataStore.get(id);
    }

    @Override
    public final List<T> getAll() {
        return new ArrayList<>(dataStore.values());
    }

    @Override
    public final void post(T entity) {
        K id = generatePrimaryKey();
        setPrimaryKey(entity, id);
        dataStore.put(id, entity);
        autoIncrement++;
    }

    @Override
    public final void put(K id, T entity) {
        if (dataStore.containsKey(id)) {
            setPrimaryKey(entity, id);
            dataStore.put(id, entity);
        }
    }

    @Override
    public final void delete(K id) {
        dataStore.remove(id);
    }

    /**
     * Genera la clave primaria autoincremental.
     */
    protected abstract K generatePrimaryKey();

    /**
     * Asigna la clave primaria a la entidad.
     */
    protected abstract void setPrimaryKey(T entity, K id);
}
