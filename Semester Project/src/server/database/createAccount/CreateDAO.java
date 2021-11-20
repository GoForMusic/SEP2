package server.database.createAccount;

public interface CreateDAO {
    String addUser(String firstname, String lastname, String username, String password, String userType);
}
