package com.sakila.controllers;

import com.sakila.data.DataContext;
import com.sakila.models.Film;

/**
 * Controlador para gestión de películas (Film)
 */
public final class FilmController extends DataContext<Film, Integer> {
    @Override
    protected Integer generatePrimaryKey() {
        return autoIncrement;
    }

    @Override
    protected void setPrimaryKey(Film entity, Integer id) {
        entity.setId(id);
    }
}
