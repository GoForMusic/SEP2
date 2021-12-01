package client.model.customer;


import shared.utils.Subject;
import shared.utils.User.Customer;

import java.util.ArrayList;

public interface CustomerModel extends Subject {
    void updateCustomer(Customer customer,String oldUsername);
    void removeCustomer(Customer customer);
    Customer getCustomer(String username);
    ArrayList<Customer> getCustomers();
}
