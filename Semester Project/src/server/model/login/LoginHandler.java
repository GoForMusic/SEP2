package server.model.login;

import shared.utils.Request;
import shared.utils.User.User;

import java.sql.SQLException;

public interface LoginHandler {
    Request login(String username, String password);
}
