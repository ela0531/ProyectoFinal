
package com.sakila.models;

import java.util.Date;

public class Rental {
    private Integer id;
    private Film film;
    private Customer customer;
    private Date rentalDate;
    private Date returnDate;

    public Rental() {}

    public Rental(Integer id, Film film, Customer customer, Date rentalDate, Date returnDate) {
        this.id = id;
        this.film = film;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Date getRentalDate() { return rentalDate; }
    public void setRentalDate(Date rentalDate) { this.rentalDate = rentalDate; }
    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }
}
