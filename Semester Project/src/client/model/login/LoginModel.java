package client.model.login;

public interface LoginModel {
    /**
     * Checks if the username is available
     * @param username the username to be checked
     * @return true if available, false if not
     */
    boolean isConnectionPossible(String username);
    /**
     * Checks if a user is allowed to login to the system
     * @param username the username of the user
     * @param password the password of the user
     * @return the String with the information about the login status..
     */
    String isLoginPossible(String username,String password);
}
