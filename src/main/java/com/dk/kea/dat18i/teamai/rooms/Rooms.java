package com.dk.kea.dat18i.teamai.rooms;

public class Rooms {

    private int room_id;
    private int room_number;
    private int capacity;
    private double price;
    private String description;

    public Rooms() {
    }

    public Rooms(int room_id, int room_number, int capacity, double price, String description) {
        this.room_id = room_id;
        this.room_number = room_number;
        this.capacity = capacity;
        this.price = price;
        this.description = description;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "room_id=" + room_id +
                ", room_number=" + room_number +
                ", capacity=" + capacity +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
