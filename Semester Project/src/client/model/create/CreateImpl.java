package client.model.create;

import client.networking.create.CreateClient;
import shared.utils.User.Customer;

public class CreateImpl implements CreateModel {
    public CreateClient client;

    public CreateImpl(CreateClient client) {
        this.client = client;
    }

    /**
     * Adds user if possible
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @return
     */
    @Override
    public String addUser(String firstname, String lastname, String username, String password) {
        Customer customer = null;
        try {
            customer = new Customer(firstname,lastname,username,password);
        } catch (Exception e) {
            return e.getMessage();
        }
        return client.addUser(customer);
    }
}
