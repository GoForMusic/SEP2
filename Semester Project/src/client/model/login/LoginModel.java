package client.model.login;

import shared.utils.Request;

public interface LoginModel {

    /**
     * Checks if a user is allowed to login to the system
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the String with the information about the login status..
     */
    Request login(String username, String password);

    void setUsername(String userName);

    String getUsername();

    void setUserType(String userType);

    String getUserType();
}
