package client.networking.login;

import shared.utils.Request;
import shared.utils.User.User;

/**
 * The client class that deals with the login
 */
public interface LoginClient {

    /**
     * Checks if the login is allowed
     * @return the result from server
     */
    Request login(String username,String password);
}
