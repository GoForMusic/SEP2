package server.database.createAccount;


/**
 * @author Sachin Baral
 * DAO for creating a user
 */
public interface CreateDAO {
    /**
     * Adds user to the database
     * @param firstname the firstname of the user
     * @param lastname the lastname of the user
     * @param username the username of the user
     * @param password the pasword of the user
     * @param userType the type of user
     * @return the string of what happened at the database
     */
    String addUser(String firstname, String lastname, String username, String password, String userType);


}
