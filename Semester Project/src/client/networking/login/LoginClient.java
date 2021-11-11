package client.networking.login;

import shared.utils.User.User;

/**
 * The client class that deals with the login
 */
public interface LoginClient {

    /**
     * Checks if the login is allowed
     * @param user
     * @return the result from server
     */
    String isLoginPossible(User user);
}
