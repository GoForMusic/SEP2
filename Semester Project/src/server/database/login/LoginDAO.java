package server.database.login;

import javafx.scene.control.PasswordField;
import shared.utils.Request;
import shared.utils.User.User;

import java.sql.SQLException;

/**
 * @author Sachin Baral
 */
public interface LoginDAO {
    /**
     * the method to look out for the username and password in database
     * @param username the username all the way from the GUI
     * @param password the password all the way from the GUI
     * @return the appropriate Request object..
     * @throws SQLException
     */
    Request login(String username, String password ) throws SQLException;
//    LoginDAO getInstance();
}
