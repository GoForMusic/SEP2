package client.model.create;

/**
 * @author Sachin Baral
 * The interface that deals with creating a new account
 */
public interface CreateModel {
    /**
     * Checks if the username is available
     * @param username the username to be checked
     * @return true if available, false if not
     */
    boolean isConnectionPossible(String username);

    /**
     * Adds user to database
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @return
     */
    String addUser(String firstname,String lastname,String username, String password);

}
