package com.sakila.controllers;

import com.sakila.models.Film;
import com.sakila.data.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmSQLController {
    public void post(Film film) {
        String sql = "INSERT INTO films (titulo, anio, genero) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, film.getTitle());
            stmt.setInt(2, film.getYear());
            stmt.setString(3, film.getGenre());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    film.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Film> getAll() {
        List<Film> films = new ArrayList<>();
        String sql = "SELECT idfilm, titulo, anio, genero FROM films";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Film film = new Film(
                    rs.getInt("idfilm"),
                    rs.getString("titulo"),
                    rs.getInt("anio"),
                    rs.getString("genero")
                );
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    public Film get(int id) {
        String sql = "SELECT idfilm, titulo, anio, genero FROM films WHERE idfilm = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Film(
                        rs.getInt("idfilm"),
                        rs.getString("titulo"),
                        rs.getInt("anio"),
                        rs.getString("genero")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void put(int id, Film film) {
        String sql = "UPDATE films SET titulo = ?, anio = ?, genero = ? WHERE idfilm = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, film.getTitle());
            stmt.setInt(2, film.getYear());
            stmt.setString(3, film.getGenre());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM films WHERE idfilm = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
