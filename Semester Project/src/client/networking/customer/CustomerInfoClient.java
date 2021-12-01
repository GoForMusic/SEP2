package client.networking.customer;

import shared.utils.User.Customer;

import java.util.ArrayList;

public interface CustomerInfoClient {
    void updateCustomer(Customer customer, String oldUsername);
    void removeCustomer(Customer customer);
    Customer getCustomer(String username);
    ArrayList<Customer> getCustomers();
}
