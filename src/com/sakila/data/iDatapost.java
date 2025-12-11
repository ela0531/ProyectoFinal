package com.sakila.data;

/**
 * Interface estándar CRUD para acceso a datos.
 * @param <T> Tipo de entidad
 * @param <K> Tipo de clave primaria
 */
public interface iDatapost<T, K> {
    T get(K id);
    java.util.List<T> getAll();
    void post(T entity);
    void put(K id, T entity);
    void delete(K id);
}
