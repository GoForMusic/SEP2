package server.database.login;

import javafx.scene.control.PasswordField;
import shared.utils.Request;
import shared.utils.User.User;

import java.sql.SQLException;

public interface LoginDAO {
    Request login(String username, String password ) throws SQLException;
}
