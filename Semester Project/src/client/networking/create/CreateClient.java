package client.networking.create;

public interface CreateClient {
    boolean isConnectionPossible(String username);
    String addUser(String firstname,String lastname,String username, String password);
}
