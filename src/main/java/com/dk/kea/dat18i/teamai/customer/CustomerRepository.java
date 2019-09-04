package com.dk.kea.dat18i.teamai.customer;

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
public class CustomerRepository {





    @Autowired
    private JdbcTemplate jdbc;

    public Customer findCustomer(int customer_id){

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customer WHERE customer_id = " + customer_id);

        Customer customer = new Customer();

        while (rs.next()) {


            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setFirst_name(rs.getString("first_name"));
            customer.setLast_name(rs.getString("last_name"));
            customer.setPhone_number(rs.getString("phone_number"));



        }
        return customer;
    }

    public List<Customer> findAllCustomers() {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customer");

        List<Customer> customerList = new ArrayList<>();

        while (rs.next()) {
            Customer customer = new Customer();

            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setFirst_name(rs.getString("first_name"));
            customer.setLast_name(rs.getString("last_name"));
            customer.setPhone_number(rs.getString("phone_number"));
            customerList.add(customer);
        }
        return customerList;
    }

    public Customer createRoom(Customer customer) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("INSERT INTO customer VALUES (null,?,?,?)", new String[]{"customer_id"});

                ps.setString(1, customer.getFirst_name());
                ps.setString(2, customer.getLast_name());
                ps.setString(3, customer.getPhone_number());

                return ps;
            }
        };
        jdbc.update(psc);
        return customer;
    }
    public void deleteCustomer(int customer_id) {

        jdbc.execute("DELETE FROM customer WHERE customer_id = " + customer_id);
    }

    public Customer update(Customer customer) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("UPDATE customer SET first_name = ?, last_name = ?, phone_number = ? WHERE customer_id =  " + customer.getCustomer_id(), new String[]{"customer_id"});


                ps.setString(1, customer.getFirst_name());
                ps.setString(2, customer.getLast_name());
                ps.setString(3, customer.getPhone_number());

                return ps;


            }
        };

        jdbc.update(psc);
        return customer;
    }

}
