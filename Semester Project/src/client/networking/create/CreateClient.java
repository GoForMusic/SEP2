package client.networking.create;

import shared.utils.User.User;

/**
 * @author Sachin Baral
 */
public interface CreateClient {


    String addUser(String firstname, String lastname, String username, String password, String userType);
}
