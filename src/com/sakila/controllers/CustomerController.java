package com.sakila.controllers;

import com.sakila.data.DataContext;
import com.sakila.models.Customer;

/**
 * Controlador para gestión de clientes (Customer)
 */
public final class CustomerController extends DataContext<Customer, Integer> {
    @Override
    protected Integer generatePrimaryKey() {
        return autoIncrement;
    }

    @Override
    protected void setPrimaryKey(Customer entity, Integer id) {
        entity.setId(id);
    }
}
