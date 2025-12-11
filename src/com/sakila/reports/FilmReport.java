package com.sakila.reports;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.sakila.models.Film;

/**
 * Reporte y exportación de películas a CSV
 */
public class FilmReport {
    public static void exportToCSV(List<Film> films, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("ID,Título,Año,Género\n");
        for (Film f : films) {
            writer.write(f.getId() + "," + f.getTitle() + "," + f.getYear() + "," + f.getGenre() + "\n");
        }
        writer.close();
    }
}
