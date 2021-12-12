package client.model.create;

import client.networking.create.CreateClient;
import shared.utils.User.Customer;
import shared.utils.User.User;

/**
 * @author Sachin
 * A class that is implement all the CreateModel interfaces functions
 */
public class CreateImpl implements CreateModel {
    public CreateClient client;

    public CreateImpl(CreateClient client) {
        this.client = client;
    }

    /**
     * Adds user if possible
     * @param firstname the first name of the user
     * @param lastname the last name of the user
     * @param username the username of the user
     * @param password the password of the user
     * @return the appropriate string from database
     */
    @Override
    public String addUser(String firstname, String lastname, String username, String password,String userType) {
        return client.addUser(firstname,lastname,username,password,userType);
    }
}
