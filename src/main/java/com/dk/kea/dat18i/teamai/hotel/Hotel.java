package com.dk.kea.dat18i.teamai.hotel;

public class Hotel {
    int hotel_id;
    String hotel_name;
    String location;

    public Hotel(int hotel_id, String hotel_name, String location) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + hotel_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
