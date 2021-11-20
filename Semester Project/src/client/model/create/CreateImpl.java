package client.model.create;

import client.networking.create.CreateClient;
import shared.utils.User.Customer;
import shared.utils.User.User;

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
    public String addUser(String firstname, String lastname, String username, String password,String userType) {
        return client.addUser(firstname,lastname,username,password,userType);
    }
}
