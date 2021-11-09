package client.model.create;

public interface CreateModel {
    void isConnectionPossible(String username);
    void addUser(String firstname,String lastname,String username, String password);

}
