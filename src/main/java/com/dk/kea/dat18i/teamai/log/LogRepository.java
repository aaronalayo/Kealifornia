package com.dk.kea.dat18i.teamai.log;

import com.dk.kea.dat18i.teamai.booking.Booking;
import com.dk.kea.dat18i.teamai.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class LogRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void addBookingCustomer() {



        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("insert into log (booking_id, customer_id)values ((select (max(booking_id)) from booking), (select (max(customer_id))from customer))", new String[]{"log_id"});




                return ps;
            }
        };
        jdbc.update(psc);



    }


}
