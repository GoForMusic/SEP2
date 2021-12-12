package client.model.customer;

import client.networking.customer.CustomerInfoClient;
import client.networking.customer.CustomerInfoImpl;
import client.networking.login.LoginClient;
import shared.utils.User.Customer;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * @author Adrian
 * A class that will implement all the function from CustomerModel interface
 */
public class CustomerModelImpl implements CustomerModel{

    private CustomerInfoClient client;

    /**
     * A constructor that will initiate the customer info client
     */
    public CustomerModelImpl(CustomerInfoClient customerInfoClient) {
        this.client = customerInfoClient;
    }

    /**
     * A function that is updating a customer details
     */
    @Override
    public void updateCustomer(Customer customer, String oldUsername) {
        client.updateCustomer(customer,oldUsername);
    }

    /**
     * A function that is removing a customer
     */
    @Override
    public void removeCustomer(Customer customer) {
        client.removeCustomer(customer);
    }

    /**
     * A function that is returning a customer
     * @return customer
     */
    @Override
    public Customer getCustomer(String username) {
        return client.getCustomer(username);
    }

    /**
     * A function that is returning a list of customers
     * @return list of customers
     */
    @Override
    public ArrayList<Customer> getCustomers() {
        return client.getCustomers();
    }

    /**
     * A function that is not needed
     */
    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    /**
     * A function that is not needed
     */
    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
