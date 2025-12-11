/*
 * Controlador SQL para Actor usando JDBC
 */
package com.sakila.controllers;

import com.sakila.models.Actor;
import com.sakila.data.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorSQLController {
    public void post(Actor actor) {
        String sql = "INSERT INTO actors (nombre) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, actor.getName());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    actor.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Actor> getAll() {
        List<Actor> actors = new ArrayList<>();
        String sql = "SELECT idactor, nombre FROM actors";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Actor actor = new Actor(rs.getInt("idactor"), rs.getString("nombre"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    /**
     * Obtiene un actor por su ID.
     */
    public Actor get(int id) {
        String sql = "SELECT idactor, nombre FROM actors WHERE idactor = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Actor(rs.getInt("idactor"), rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Actualiza un actor por su ID.
     */
    public void put(int id, Actor actor) {
        String sql = "UPDATE actors SET nombre = ? WHERE idactor = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, actor.getName());
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un actor por su ID.
     */
    public void delete(int id) {
        String sql = "DELETE FROM actors WHERE idactor = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
