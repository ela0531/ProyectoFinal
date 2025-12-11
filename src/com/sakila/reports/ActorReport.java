package com.sakila.reports;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.sakila.models.Actor;

/**
 * Reporte y exportación de actores a CSV
 */
public class ActorReport {
    public static void exportToCSV(List<Actor> actors, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("ID,Nombre\n");
        for (Actor a : actors) {
            writer.write(a.getId() + "," + a.getName() + "\n");
        }
        writer.close();
    }
}
