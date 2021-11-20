package client.model.create;

/**
 * @author Sachin Baral
 * The interface that deals with creating a new account
 */
public interface CreateModel {

    /**
     * Adds user to database
     * @param firstname the firstname
     * @param lastname the lastname
     * @param username the username
     * @param password the password
     * @return the result from the client
     */
    String addUser(String firstname,String lastname,String username, String password,String userType);

}
