package client.model.customer;

import client.networking.customer.CustomerInfoClient;
import client.networking.customer.CustomerInfoImpl;
import client.networking.login.LoginClient;
import shared.utils.User.Customer;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class CustomerModelImpl implements CustomerModel{

    private CustomerInfoClient client;

    public CustomerModelImpl(CustomerInfoClient customerInfoClient) {
        this.client = customerInfoClient;
    }

    @Override
    public void updateCustomer(Customer customer, String oldUsername) {
        client.updateCustomer(customer,oldUsername);
    }

    @Override
    public void removeCustomer(Customer customer) {
        client.removeCustomer(customer);
    }

    @Override
    public Customer getCustomer(String username) {
        return client.getCustomer(username);
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return client.getCustomers();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
