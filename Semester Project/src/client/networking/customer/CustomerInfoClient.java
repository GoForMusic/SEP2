package client.networking.customer;

import shared.utils.User.Customer;

import java.util.ArrayList;

public interface CustomerInfoClient {
    Customer getCustomer(String username);
    ArrayList<Customer> getCustomers();
}
