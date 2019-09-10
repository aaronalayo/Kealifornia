package com.dk.kea.dat18i.teamai.booking;


import com.dk.kea.dat18i.teamai.customer.Customer;
import com.dk.kea.dat18i.teamai.rooms.Rooms;

import java.sql.Date;

public class Booking {

    private int booking_id;
    private Date check_in;
    private Date check_out;
    private int persons;
    private int number_of_rooms;
    private Customer customer;
    private Rooms room;

    public Booking() {
    }

    public Booking(int booking_id, Date check_in, Date check_out, int persons, int number_of_rooms, Customer customer, Rooms room) {
        this.booking_id = booking_id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.persons = persons;
        this.number_of_rooms = number_of_rooms;
        this.customer = customer;
        this.room = room;
    }

    public int getBooking_id() {
        return this.booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public int getNumber_of_rooms() {
        return number_of_rooms;
    }

    public void setNumber_of_rooms(int number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }
}
