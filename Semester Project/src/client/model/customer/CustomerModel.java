package client.model.customer;


import shared.utils.Subject;
import shared.utils.User.Customer;

import java.util.ArrayList;

public interface CustomerModel extends Subject {
    Customer getCustomer(String username);
    ArrayList<Customer> getCustomers();
}
