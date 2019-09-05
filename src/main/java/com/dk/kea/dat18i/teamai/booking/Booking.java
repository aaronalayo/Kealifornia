package com.dk.kea.dat18i.teamai.booking;


import com.dk.kea.dat18i.teamai.customer.Customer;
import com.dk.kea.dat18i.teamai.rooms.Rooms;

import java.util.Date;

public class Booking {

    private int booking_id;
    private Date check_in;
    private Date check_out;
    private Customer customer_id;
    private Rooms room_id;

    public Booking() {
    }

    public Booking(int booking_id, Date check_in, Date check_out, Customer customer_id, Rooms room_id) {
        this.booking_id = booking_id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.customer_id = customer_id;
        this.room_id = room_id;
    }

    public int getBooking_id() {
        return booking_id;
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

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Rooms getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Rooms room_id) {
        this.room_id = room_id;
    }
}
