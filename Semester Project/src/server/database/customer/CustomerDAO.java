package server.database.customer;

import shared.utils.User.Customer;

import java.util.ArrayList;

public interface CustomerDAO {
    Customer getCustomer(String username);
    ArrayList<Customer> getCustomers();
}
