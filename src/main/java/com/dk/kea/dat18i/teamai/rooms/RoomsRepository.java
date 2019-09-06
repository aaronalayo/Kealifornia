package com.dk.kea.dat18i.teamai.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomsRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Rooms findRoom(int room_id){

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM rooms WHERE room_id = ?;", room_id);
        Rooms room = new Rooms();

        while (rs.next()) {


           room.setRoom_id(rs.getInt("room_id"));
           room.setRoom_number(rs.getInt("room_number"));
           room.setCapacity(rs.getInt("capacity"));
           room.setPrice(rs.getDouble("price"));
           room.setDescription(rs.getString("description"));


        }
        return room;
    }

    public List<Rooms> findAllRooms() {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM rooms");

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

    public Rooms createRoom(Rooms rooms) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("INSERT INTO rooms VALUES (null,?,?,?,?)", new String[]{"room_id"});

                ps.setInt(1, rooms.getRoom_number());
                ps.setInt(2, rooms.getCapacity());
                ps.setDouble(3, rooms.getPrice());
                ps.setString(4, rooms.getDescription());

                return ps;
            }
        };
        jdbc.update(psc);
        return rooms;
    }
    public void deleteRoom(int room_id) {

        jdbc.execute("DELETE FROM rooms WHERE room_id = " + room_id);
    }

    public Rooms update(Rooms room) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("UPDATE rooms SET room_number = ?, capacity = ?, price = ?, description = ? WHERE room_id =  " + room.getRoom_id(), new String[]{"room_id"});


                ps.setInt(1,room.getRoom_number());
                ps.setInt(2, room.getCapacity());
                ps.setDouble(3, room.getPrice());
                ps.setString(4, room.getDescription());

                return ps;


            }
        };

        jdbc.update(psc);
        return room;
    }





}
