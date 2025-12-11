package com.sakila.reports;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.sakila.models.Customer;

/**
 * Reporte y exportación de clientes a CSV
 */
public class CustomerReport {
    public static void exportToCSV(List<Customer> customers, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("ID,Nombre,Teléfono,Email\n");
        for (Customer c : customers) {
            writer.write(c.getId() + "," + c.getName() + "," + c.getPhone() + "," + c.getEmail() + "\n");
        }
        writer.close();
    }
}
