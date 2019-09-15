package com.dk.kea.dat18i.teamai.booking;


import com.dk.kea.dat18i.teamai.customer.Customer;
import com.dk.kea.dat18i.teamai.rooms.Rooms;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class Booking {

    private int booking_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_in;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate check_out;
    private int persons;
    private int number_of_rooms;


    public Booking() {
    }

    public Booking(int booking_id, LocalDate check_in, LocalDate check_out, int persons, int number_of_rooms) {
        this.booking_id = booking_id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.persons = persons;
        this.number_of_rooms = number_of_rooms;

    }

    public int getBooking_id() {
        return this.booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public LocalDate getCheck_in() {
        return check_in;
    }

    public void setCheck_in(LocalDate check_in) {
        this.check_in = check_in;
    }

    public LocalDate getCheck_out() {
        return check_out;
    }

    public void setCheck_out(LocalDate check_out) {
        this.check_out = check_out;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public int getPersons() {
        return persons;
    }

    public int getNumber_of_rooms() {
        return number_of_rooms;
    }

    public void setNumber_of_rooms(int number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }


}
