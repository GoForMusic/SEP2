package server.database.customer;

import shared.utils.User.Customer;

import java.util.ArrayList;

public interface CustomerDAO {
    void updateCustomer(Customer customer);
    void removeCustomer(Customer customer);
    Customer getCustomer(String username);
    ArrayList<Customer> getCustomers();
}
