package client.model.create;

/**
 * @author Sachin Baral
 * The interface that deals with creating a new account
 */
public interface CreateModel {

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
