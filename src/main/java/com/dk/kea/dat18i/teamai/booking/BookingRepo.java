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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
            booking.setCheck_in(rs.getDate("check_in_date"));
            booking.setCheck_out(rs.getDate("check_out"));
            booking.setPersons(rs.getInt("persons"));
            booking.setNumber_of_rooms(rs.getInt("number_of_rooms"));
            booking.setCustomer(customerRepo.findCustomer(rs.getInt("customer_id")));
            booking.setRoom(roomRepo.findRoom(rs.getInt("room_id")));
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
            booking.setCheck_in(rs.getDate("check_in_date"));
            booking.setCheck_out(rs.getDate("check_out"));
            booking.setPersons(rs.getInt("persons"));
            booking.setNumber_of_rooms(rs.getInt("number_of_rooms"));
            booking.setCustomer(customerRepo.findCustomer(rs.getInt("customer_id")));
            booking.setRoom(roomRepo.findRoom(rs.getInt("room_id")));



        }
        return booking;
    }



    public int addBooking(Booking booking) {

            KeyHolder id = new GeneratedKeyHolder();
            String sql = "INSERT INTO booking VALUES (null,?,?,?,?)";

            PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                    ps.setDate(1, booking.getCheck_in());
                    ps.setDate(2, booking.getCheck_out());
                    ps.setInt(3,booking.getPersons());
                    ps.setInt(4, booking.getNumber_of_rooms());
                    return ps;

                }
            };

            jdbc.update(psc, id);

            return id.getKey().intValue();
        }

        public void updateOne(int id, Booking booking) {
            String sql = "UPDATE booking SET check_in = ?, check_out = ?, persons = ?, number_of_rooms = ?, customer_id = ?, room_id = ? WHERE id = ?";
            jdbc.update(sql, booking.getCheck_in(), booking.getCheck_out(), booking.getPersons(), booking.getNumber_of_rooms(), booking.getCustomer(), booking.getRoom(), id);
        }

        public void deleteOne(int id) {

            jdbc.update("DELETE FROM booking WHERE id = " + id);
        }


}
