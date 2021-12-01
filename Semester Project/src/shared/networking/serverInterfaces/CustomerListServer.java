package shared.networking.serverInterfaces;

import shared.utils.User.Customer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CustomerListServer {
    Customer getCustomer(String username) throws RemoteException;
    ArrayList<Customer> getCustomers() throws RemoteException;
}
