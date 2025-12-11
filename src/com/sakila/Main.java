
package com.sakila;

import com.sakila.controllers.*;
import com.sakila.models.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilmSQLController filmController = new FilmSQLController();
        ActorSQLController actorController = new ActorSQLController();
        CustomerController customerController = new CustomerController();
        RentalController rentalController = new RentalController();
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("--- Menú Principal Sakila ---");
            System.out.println("1. Gestionar Películas");
            System.out.println("2. Gestionar Actores");
            System.out.println("3. Gestionar Clientes");
            System.out.println("4. Gestionar Rentas");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");
            option = sc.nextInt();
            sc.nextLine();
            switch(option) {
                case 1:
                    int opFilm;
                    do {
                        System.out.println("--- CRUD Películas ---");
                        System.out.println("1. Agregar película");
                        System.out.println("2. Listar películas");
                        System.out.println("3. Editar película");
                        System.out.println("4. Eliminar película");
                        System.out.println("0. Volver");
                        System.out.print("Opción: ");
                        opFilm = sc.nextInt();
                        sc.nextLine();
                        switch(opFilm) {
                            case 1:
                                System.out.print("Título: ");
                                String title = sc.nextLine();
                                System.out.print("Año: ");
                                int year = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Género: ");
                                String genre = sc.nextLine();
                                Film film = new Film(null, title, year, genre);
                                filmController.post(film);
                                System.out.println("Película agregada.");
                                break;
                            case 2:
                                System.out.println("--- Lista de Películas ---");
                                for (Film f : filmController.getAll()) {
                                    System.out.println(f.getId() + ". " + f.getTitle() + " (" + f.getYear() + ") - " + f.getGenre());
                                }
                                break;
                            case 3:
                                System.out.print("ID de película a editar: ");
                                int idEdit = sc.nextInt();
                                sc.nextLine();
                                Film filmEdit = filmController.get(idEdit);
                                if (filmEdit != null) {
                                    System.out.print("Nuevo título (actual: " + filmEdit.getTitle() + "): ");
                                    String newTitle = sc.nextLine();
                                    System.out.print("Nuevo año (actual: " + filmEdit.getYear() + "): ");
                                    int newYear = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Nuevo género (actual: " + filmEdit.getGenre() + "): ");
                                    String newGenre = sc.nextLine();
                                    filmEdit.setTitle(newTitle);
                                    filmEdit.setYear(newYear);
                                    filmEdit.setGenre(newGenre);
                                    filmController.put(idEdit, filmEdit);
                                    System.out.println("Película actualizada.");
                                } else {
                                    System.out.println("No existe película con ese ID.");
                                }
                                break;
                            case 4:
                                System.out.print("ID de película a eliminar: ");
                                int idDel = sc.nextInt();
                                sc.nextLine();
                                filmController.delete(idDel);
                                System.out.println("Película eliminada.");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    } while(opFilm != 0);
                    break;
                case 2:
                    int opActor;
                    do {
                        System.out.println("--- CRUD Actores ---");
                        System.out.println("1. Agregar actor");
                        System.out.println("2. Listar actores");
                        System.out.println("3. Editar actor");
                        System.out.println("4. Eliminar actor");
                        System.out.println("0. Volver");
                        System.out.print("Opción: ");
                        opActor = sc.nextInt();
                        sc.nextLine();
                        switch(opActor) {
                            case 1:
                                System.out.print("Nombre: ");
                                String name = sc.nextLine();
                                Actor actor = new Actor(null, name);
                                actorController.post(actor);
                                System.out.println("Actor agregado.");
                                break;
                            case 2:
                                System.out.println("--- Lista de Actores ---");
                                for (Actor a : actorController.getAll()) {
                                    System.out.println(a.getId() + ". " + a.getName());
                                }
                                break;
                            case 3:
                                System.out.print("ID de actor a editar: ");
                                int idEditA = sc.nextInt();
                                sc.nextLine();
                                Actor actorEdit = actorController.get(idEditA);
                                if (actorEdit != null) {
                                    System.out.print("Nuevo nombre (actual: " + actorEdit.getName() + "): ");
                                    String newName = sc.nextLine();
                                    actorEdit.setName(newName);
                                    actorController.put(idEditA, actorEdit);
                                    System.out.println("Actor actualizado.");
                                } else {
                                    System.out.println("No existe actor con ese ID.");
                                }
                                break;
                            case 4:
                                System.out.print("ID de actor a eliminar: ");
                                int idDelA = sc.nextInt();
                                sc.nextLine();
                                actorController.delete(idDelA);
                                System.out.println("Actor eliminado.");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    } while(opActor != 0);
                    break;
                case 3:
                    int opCliente;
                    do {
                        System.out.println("--- CRUD Clientes ---");
                        System.out.println("1. Agregar cliente");
                        System.out.println("2. Listar clientes");
                        System.out.println("3. Editar cliente");
                        System.out.println("4. Eliminar cliente");
                        System.out.println("0. Volver");
                        System.out.print("Opción: ");
                        opCliente = sc.nextInt();
                        sc.nextLine();
                        switch(opCliente) {
                            case 1:
                                System.out.print("Nombre: ");
                                String cname = sc.nextLine();
                                System.out.print("Teléfono: ");
                                String phone = sc.nextLine();
                                System.out.print("Email: ");
                                String email = sc.nextLine();
                                Customer customer = new Customer(null, cname, phone, email);
                                customerController.post(customer);
                                System.out.println("Cliente agregado.");
                                break;
                            case 2:
                                System.out.println("--- Lista de Clientes ---");
                                for (Customer c : customerController.getAll()) {
                                    System.out.println(c.getId() + ". " + c.getName() + " - " + c.getPhone() + " - " + c.getEmail());
                                }
                                break;
                            case 3:
                                System.out.print("ID de cliente a editar: ");
                                int idEditC = sc.nextInt();
                                sc.nextLine();
                                Customer custEdit = customerController.get(idEditC);
                                if (custEdit != null) {
                                    System.out.print("Nuevo nombre (actual: " + custEdit.getName() + "): ");
                                    String newCName = sc.nextLine();
                                    System.out.print("Nuevo teléfono (actual: " + custEdit.getPhone() + "): ");
                                    String newPhone = sc.nextLine();
                                    System.out.print("Nuevo email (actual: " + custEdit.getEmail() + "): ");
                                    String newEmail = sc.nextLine();
                                    custEdit.setName(newCName);
                                    custEdit.setPhone(newPhone);
                                    custEdit.setEmail(newEmail);
                                    customerController.put(idEditC, custEdit);
                                    System.out.println("Cliente actualizado.");
                                } else {
                                    System.out.println("No existe cliente con ese ID.");
                                }
                                break;
                            case 4:
                                System.out.print("ID de cliente a eliminar: ");
                                int idDelC = sc.nextInt();
                                sc.nextLine();
                                customerController.delete(idDelC);
                                System.out.println("Cliente eliminado.");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    } while(opCliente != 0);
                    break;
                case 4:
                    int opRenta;
                    do {
                        System.out.println("--- CRUD Rentas ---");
                        System.out.println("1. Agregar renta");
                        System.out.println("2. Listar rentas");
                        System.out.println("3. Editar renta");
                        System.out.println("4. Eliminar renta");
                        System.out.println("0. Volver");
                        System.out.print("Opción: ");
                        opRenta = sc.nextInt();
                        sc.nextLine();
                        switch(opRenta) {
                            case 1:
                                System.out.print("ID Película: ");
                                int filmId = sc.nextInt();
                                sc.nextLine();
                                Film rentFilm = filmController.get(filmId);
                                System.out.print("ID Cliente: ");
                                int custId = sc.nextInt();
                                sc.nextLine();
                                Customer rentCust = customerController.get(custId);
                                System.out.print("Fecha renta (yyyy-MM-dd): ");
                                String dateR = sc.nextLine();
                                System.out.print("Fecha devolución (yyyy-MM-dd): ");
                                String dateD = sc.nextLine();
                                java.util.Date rentalDate = null, returnDate = null;
                                try {
                                    rentalDate = java.sql.Date.valueOf(dateR);
                                    returnDate = java.sql.Date.valueOf(dateD);
                                } catch(Exception e) {
                                    System.out.println("Formato de fecha inválido.");
                                }
                                if (rentFilm != null && rentCust != null && rentalDate != null && returnDate != null) {
                                    Rental rental = new Rental(null, rentFilm, rentCust, rentalDate, returnDate);
                                    rentalController.post(rental);
                                    System.out.println("Renta agregada.");
                                } else {
                                    System.out.println("Datos inválidos para la renta.");
                                }
                                break;
                            case 2:
                                System.out.println("--- Lista de Rentas ---");
                                for (Rental r : rentalController.getAll()) {
                                    System.out.println(r.getId() + ". " + r.getFilm().getTitle() + " - " + r.getCustomer().getName() + " | " + r.getRentalDate() + " a " + r.getReturnDate());
                                }
                                break;
                            case 3:
                                System.out.print("ID de renta a editar: ");
                                int idEditR = sc.nextInt();
                                sc.nextLine();
                                Rental rentEdit = rentalController.get(idEditR);
                                if (rentEdit != null) {
                                    System.out.print("Nuevo ID Película (actual: " + rentEdit.getFilm().getId() + "): ");
                                    int newFilmId = sc.nextInt();
                                    sc.nextLine();
                                    Film newFilm = filmController.get(newFilmId);
                                    System.out.print("Nuevo ID Cliente (actual: " + rentEdit.getCustomer().getId() + "): ");
                                    int newCustId = sc.nextInt();
                                    sc.nextLine();
                                    Customer newCust = customerController.get(newCustId);
                                    System.out.print("Nueva fecha renta (actual: " + rentEdit.getRentalDate() + "): ");
                                    String newDateR = sc.nextLine();
                                    System.out.print("Nueva fecha devolución (actual: " + rentEdit.getReturnDate() + "): ");
                                    String newDateD = sc.nextLine();
                                    java.util.Date newRentalDate = null, newReturnDate = null;
                                    try {
                                        newRentalDate = java.sql.Date.valueOf(newDateR);
                                        newReturnDate = java.sql.Date.valueOf(newDateD);
                                    } catch(Exception e) {
                                        System.out.println("Formato de fecha inválido.");
                                    }
                                    if (newFilm != null && newCust != null && newRentalDate != null && newReturnDate != null) {
                                        rentEdit.setFilm(newFilm);
                                        rentEdit.setCustomer(newCust);
                                        rentEdit.setRentalDate(newRentalDate);
                                        rentEdit.setReturnDate(newReturnDate);
                                        rentalController.put(idEditR, rentEdit);
                                        System.out.println("Renta actualizada.");
                                    } else {
                                        System.out.println("Datos inválidos para la renta.");
                                    }
                                } else {
                                    System.out.println("No existe renta con ese ID.");
                                }
                                break;
                            case 4:
                                System.out.print("ID de renta a eliminar: ");
                                int idDelR = sc.nextInt();
                                sc.nextLine();
                                rentalController.delete(idDelR);
                                System.out.println("Renta eliminada.");
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción inválida");
                        }
                    } while(opRenta != 0);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while(option != 0);
        sc.close();
    }
}
