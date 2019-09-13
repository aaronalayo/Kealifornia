package com.dk.kea.dat18i.teamai.hotel;

import com.dk.kea.dat18i.teamai.rooms.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Rooms> findAllRooms() {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM rooms where hotel_id=2");

        List<Rooms> roomsList = new ArrayList<>();

        while (rs.next()) {
            Rooms room = new Rooms();

            room.setRoom_id(rs.getInt("room_id"));
            room.setRoom_number(rs.getInt("room_number"));
            room.setCapacity(rs.getInt("capacity"));
            room.setPrice(rs.getDouble("price"));
            room.setDescription(rs.getString("description"));
            roomsList.add(room);
        }
        return roomsList;
    }



}
