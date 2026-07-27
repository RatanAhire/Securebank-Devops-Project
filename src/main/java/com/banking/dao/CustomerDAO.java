package com.banking.dao;

import com.banking.model.Customer;

public class CustomerDAO {

    public Customer login(String username, String password) {

        // TODO:
        // Replace this with MySQL query

        if ("admin".equals(username)
                && "admin123".equals(password)) {

            Customer customer = new Customer();

            customer.setCustomerId(1);
            customer.setFullName("Ratan Ahire");
            customer.setUsername(username);
            customer.setEmail("ratan@example.com");
            customer.setMobile("9876543210");

            return customer;
        }

        return null;

    }

    public boolean registerCustomer(Customer customer) {

        // TODO:
        // Insert customer into database

        return true;

    }

}