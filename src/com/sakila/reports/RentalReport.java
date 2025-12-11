package com.sakila.reports;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.sakila.models.Rental;

/**
 * Reporte y exportación de rentas a CSV
 */
public class RentalReport {
    public static void exportToCSV(List<Rental> rentals, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("ID,Película,Cliente,FechaRenta,FechaDevolución\n");
        for (Rental r : rentals) {
            writer.write(r.getId() + "," + r.getFilm().getTitle() + "," + r.getCustomer().getName() + "," + r.getRentalDate() + "," + r.getReturnDate() + "\n");
        }
        writer.close();
    }
}
