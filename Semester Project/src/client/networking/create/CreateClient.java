package client.networking.create;

public interface CreateClient {
    void isConnectionPossible(String username);
    void addUser(String firstname,String lastname,String username, String password);
}
