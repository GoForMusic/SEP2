package server.database.Customer;

import shared.utils.User.Customer;

import java.util.ArrayList;

/**
 * Interface for database
 */
public interface CustomerRepository {
    void insertCustomer(Customer customer);
    Customer getCustomer(int customerID);
    Customer getCustomerLogin(String userName, String password);
    void updateCustomer(int customerID, Customer newCustomer);
    ArrayList<Customer> getCustomers();
    void deleteCustomer(int customerID);

    boolean doesUsernameExists(String username);
}
