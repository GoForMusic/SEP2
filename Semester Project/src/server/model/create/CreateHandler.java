package server.model.create;

import shared.utils.User.User;

public interface CreateHandler {

    String addUser(String firstname, String lastname, String username, String password, String userType);
}
