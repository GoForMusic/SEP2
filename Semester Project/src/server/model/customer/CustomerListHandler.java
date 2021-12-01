package server.model.customer;

import shared.utils.User.Customer;

import java.util.ArrayList;

public interface CustomerListHandler {
    Customer getCustomer(String username);
    ArrayList<Customer> getCustomers();
}
