package server.model.create;

import shared.utils.User.User;

public interface CreateHandler {
    boolean doesUsernameExists(String username);

    String addUser(User user);
}
