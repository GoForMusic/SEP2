package server.model.create;

import shared.utils.User.User;

public interface CreateHandler {
    boolean addUser(User user)  ;
    boolean doesUsernameExists(String username);
}
