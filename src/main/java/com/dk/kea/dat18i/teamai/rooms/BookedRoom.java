package com.dk.kea.dat18i.teamai.rooms;

import java.util.List;

public class BookedRoom {

    private int booked_room_id;
    private List<Rooms> bookedRoom;

    public BookedRoom(int booked_room_id, List<Rooms> bookedRoom) {
        this.booked_room_id = booked_room_id;
        this.bookedRoom = bookedRoom;
    }

    public int getBooked_room_id() {
        return booked_room_id;
    }

    public void setBooked_room_id(int booked_room_id) {
        this.booked_room_id = booked_room_id;
    }

    public List<Rooms> getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(List<Rooms> bookedRoom) {
        this.bookedRoom = bookedRoom;
    }
}
