package com.dk.kea.dat18i.teamai.booking;

import com.dk.kea.dat18i.teamai.customer.Customer;
import com.dk.kea.dat18i.teamai.customer.CustomerRepository;
import com.dk.kea.dat18i.teamai.rooms.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepo {

        @Autowired
        private JdbcTemplate jdbc;

        @Autowired
        private CustomerRepository customerRepo;

        @Autowired
        private RoomsRepository roomRepo;
//        public List<Booking> findAll() {
//            String sql = "SELECT * FROM booking";
//            List<Booking> bookings = jdbc.query(sql, new BeanPropertyRowMapper<>(Booking.class));
//
//            return bookings;
//        }

    public List<Booking> findAll() {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking");

        List<Booking> bookingList = new ArrayList<>();

        while (rs.next()) {
            Booking booking = new Booking();

            booking.setBooking_id(rs.getInt("booking_id"));
            booking.setCheck_in(rs.getDate("check_in").toLocalDate());
            booking.setCheck_out(rs.getDate("check_out").toLocalDate());
            booking.setPersons(rs.getInt("persons"));
            booking.setNumber_of_rooms(rs.getInt("number_of_rooms"));

            bookingList.add(booking);
        }
        return bookingList;
    }
//        public Booking findOne(int booking_id) {
//            String sql = "SELECT * FROM booking WHERE booking_id=" + booking_id;
//            return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Booking.class));
//        }

    public Booking  findOne(int booking_id){

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking WHERE booking_id = " + booking_id);

        Booking booking = new Booking();

        while (rs.next()) {


            booking.setBooking_id(rs.getInt("booking_id"));
            booking.setCheck_in(rs.getDate("check_in").toLocalDate());
            booking.setCheck_out(rs.getDate("check_out").toLocalDate());
            booking.setPersons(rs.getInt("persons"));
            booking.setNumber_of_rooms(rs.getInt("number_of_rooms"));




        }
        return booking;
    }



    public Booking addBooking(Booking booking) {

            PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                    PreparedStatement ps = connection.prepareStatement("INSERT INTO booking VALUES (null,?,?,?,?)", new String[]{"booking_id"});


                 ps.setDate(1,Date.valueOf(booking.getCheck_in()));
                 ps.setDate(2,Date.valueOf(booking.getCheck_out()));
                 ps.setInt(3,booking.getPersons());
                 ps.setInt(4,booking.getNumber_of_rooms());

                    return ps;
                }
            };
            jdbc.update(psc);
            return booking;


        }

        public void updateOne( Booking booking) {
            String sql = "UPDATE booking SET check_in = ?, check_out = ?, persons = ?, number_of_rooms = ?, customer_id = ?, room_id = ? WHERE booking_id = ?";
            jdbc.update(sql, booking.getCheck_in(), booking.getCheck_out(), booking.getPersons(), booking.getNumber_of_rooms());
        }

        public void deleteOne(int booking_id) {

            jdbc.update("DELETE FROM booking WHERE id = " + booking_id);
        }

    public Booking findLastBooking() {

        SqlRowSet rs = jdbc.queryForRowSet("select  * from booking where booking_id = (select (max(booking_id)) from booking)");


        Booking lastBooking = new Booking();

        while (rs.next()) {


            lastBooking.setBooking_id(rs.getInt("booking_id"));
            lastBooking.setCheck_in(rs.getDate("check_in").toLocalDate());
            lastBooking.setCheck_out(rs.getDate("check_out").toLocalDate());
            lastBooking.setPersons(rs.getInt("persons"));
            lastBooking.setNumber_of_rooms(rs.getInt("number_of_rooms"));


        }
        return lastBooking;
    }

}
