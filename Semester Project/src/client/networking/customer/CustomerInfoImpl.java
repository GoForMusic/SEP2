package client.networking.customer;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.User.Customer;

import java.util.ArrayList;

public class CustomerInfoImpl implements CustomerInfoClient{

    private Server server;

    public CustomerInfoImpl() {
        try {
            server = GetServer.getServerFromRmi();
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public Customer getCustomer(String username) {
        return null;
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> list= new ArrayList<>();
        list.add(new Customer("Adrian","Militaru","Adri123","12345","test@test.com"));
        list.add(new Customer("Adrian2","Militaru2","Adri1234","12345","test2@test2.com"));

        return list;
    }
}
