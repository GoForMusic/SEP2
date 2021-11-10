package client.networking.create;

public interface CreateClient {
    /**
     * Checks if the username is available
     * @param username the username to be checked
     * @return the result from server
     */
    boolean isConnectionPossible(String username);

    /**
     * Adds the user to database
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @return the response from server
     */
    String addUser(String firstname,String lastname,String username, String password);
}
