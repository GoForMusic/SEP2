package client.networking.customer;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.User.Customer;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author Adrian
 * A class that will implement all the functions from Customer info client
 */
public class CustomerInfoImpl implements CustomerInfoClient{

    private Server server;

    /**
     * A constructor that will implement RMI connection
     */
    public CustomerInfoImpl() {
        try {
            server = GetServer.getServerFromRmi();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * A function that will update customer details
     * @param customer
     * @param oldUsername
     */
    @Override
    public void updateCustomer(Customer customer, String oldUsername) {
        try {
            server.getCustomerListServer().updateCustomer(customer,oldUsername);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A function that will remove a customer
     * @param customer
     */
    @Override
    public void removeCustomer(Customer customer) {
        try {
            server.getCustomerListServer().removeCustomer(customer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A function that will return a customer
     * @param username
     * @return customer details
     */
    @Override
    public Customer getCustomer(String username) {
        try {
            return server.getCustomerListServer().getCustomer(username);
        } catch (RemoteException e) {
            System.out.println("Cannot connect!");
            return null;
        }
    }

    /**
     * A function that will return a list of customers
     * @return list of customers
     */
    @Override
    public ArrayList<Customer> getCustomers() {
        try {
            return server.getCustomerListServer().getCustomers();
        } catch (RemoteException e) {
            System.out.println("Cannot connect!");
            return null;
        }
    }
}
