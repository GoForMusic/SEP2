package server.model.login;

import shared.utils.User;

public interface LoginHandler {
    String isLoginPossible(User user);
}
