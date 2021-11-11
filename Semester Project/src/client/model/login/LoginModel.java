package client.model.login;

import shared.utils.User;

public interface LoginModel {

    /**
     * Checks if a user is allowed to login to the system
     * @param username the username of the user
     * @param password the password of the user
     * @return the String with the information about the login status..
     */
    String isLoginPossible(String username,String password);
}
