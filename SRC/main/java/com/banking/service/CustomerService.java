package com.securebank.service;

import com.securebank.model.Customer;

public class CustomerService {

    public Customer login(String username, String password) {

        // Temporary Login (Without Database)
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

        if (customer == null) {
            return false;
        }

        // Temporary Success
        return true;
    }

}