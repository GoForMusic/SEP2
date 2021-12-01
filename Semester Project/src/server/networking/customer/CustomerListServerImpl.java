package server.networking.customer;

import server.model.customer.CustomerListHandler;
import shared.networking.serverInterfaces.CustomerListServer;
import shared.utils.User.Customer;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CustomerListServerImpl implements CustomerListServer {

    private CustomerListHandler customerListHandler;

    public CustomerListServerImpl(CustomerListHandler customerListHandler) throws RemoteException {
        this.customerListHandler = customerListHandler;
        UnicastRemoteObject.exportObject(this,0);
    }


    @Override
    public void updateCustomer(Customer customer, String oldCustomer) throws RemoteException {
        customerListHandler.updateCustomer(customer,oldCustomer);
    }

    @Override
    public void removeCustomer(Customer customer) throws RemoteException {
        customerListHandler.removeCustomer(customer);
    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return customerListHandler.getCustomer(username);
    }

    @Override
    public ArrayList<Customer> getCustomers() throws RemoteException {
        return customerListHandler.getCustomers();
    }
}
