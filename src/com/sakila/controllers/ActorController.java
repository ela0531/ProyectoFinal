package com.sakila.controllers;

import com.sakila.data.DataContext;
import com.sakila.models.Actor;

/**
 * Controlador para gestión de actores (Actor)
 */
public final class ActorController extends DataContext<Actor, Integer> {
    @Override
    protected Integer generatePrimaryKey() {
        return autoIncrement;
    }

    @Override
    protected void setPrimaryKey(Actor entity, Integer id) {
        entity.setId(id);
    }
}
