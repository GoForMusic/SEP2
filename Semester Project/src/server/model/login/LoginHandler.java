package server.model.login;

import shared.utils.User.User;

public interface LoginHandler {
    String isLoginPossible(User user);
}
