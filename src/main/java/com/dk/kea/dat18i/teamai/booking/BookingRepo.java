package com.dk.kea.dat18i.teamai.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class BookingRepo {

        @Autowired
        private JdbcTemplate jdbc;


        public List<Booking> findAll() {
            String sql = "SELECT * FROM booking";
            List<Booking> theaters = jdbc.query(sql, new BeanPropertyRowMapper<>(Booking.class));

            return theaters;
        }

        public Booking findOne(int id) {
            String sql = "SELECT * FROM booking WHERE id=" + id;
            return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Booking.class));
        }


        public int addBooking(Booking booking) {

            KeyHolder id = new GeneratedKeyHolder();
            String sql = "INSERT INTO booking VALUES (null,?,?,?,?)";

            PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    //ps.setInt(1, 1);
                    ps.setDate(1, booking.getCheck_in());
                    ps.setDate(2, booking.getCheck_out());
                    ps.setObject(3, booking.getCustomer_id());
                    ps.setObject(4, booking.getRoom_id());
                    return ps;

                }
            };

            jdbc.update(psc, id);

            return id.getKey().intValue();
        }

        public void updateOne(int id, Booking booking) {
            String sql = "UPDATE booking SET check_in = ?, check_out = ?, customer_id = ?, room_id = ? WHERE id = ?";
            jdbc.update(sql, booking.getCheck_in(), booking.getCheck_out(), booking.getCustomer_id(), booking.getRoom_id(), id);
        }

        public void deleteOne(int id) {

            jdbc.update("DELETE FROM booking WHERE id = " + id);
        }
    }
