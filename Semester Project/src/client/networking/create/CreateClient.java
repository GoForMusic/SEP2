package client.networking.create;

import shared.utils.User.User;

/**
 * @author Sachin Baral
 */
public interface CreateClient {


    /**
     * Adds user to server
     * @param user
     * @return the response from the server
     */
    String addUser(User user);
}
