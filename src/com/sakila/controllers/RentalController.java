package com.sakila.controllers;

import com.sakila.data.DataContext;
import com.sakila.models.Rental;

/**
 * Controlador para gestión de rentas (Rental)
 */
public final class RentalController extends DataContext<Rental, Integer> {
    @Override
    protected Integer generatePrimaryKey() {
        return autoIncrement;
    }

    @Override
    protected void setPrimaryKey(Rental entity, Integer id) {
        entity.setId(id);
    }
}
