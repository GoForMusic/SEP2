package server.model.login;

import shared.utils.User.User;

import java.sql.SQLException;

public interface LoginHandler {
    String isLoginPossible(User user);
}
