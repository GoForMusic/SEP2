package server.model.login;

import server.database.login.LoginDAO;
import server.database.login.LoginDAOImpl;
import shared.utils.Request;
import shared.utils.User.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginHandlerImpl implements LoginHandler {

    private List<User> allUsers;
    private List<String> allUsernames;
    private LoginDAO loginDAO;

    public LoginHandlerImpl() throws SQLException {
        allUsers = new ArrayList<>();
        allUsernames = new ArrayList<>();
        loginDAO= new LoginDAOImpl();
        // allUsers.add(new User("Sachin", "Baral", "sachin07", "sachin123"));
    }


    @Override
    public Request login(String username, String password) {
        try {
            return loginDAO.login(username,password);
        } catch (SQLException e) {
            return new Request("Error connecting to database",null);
        }
    }

//    private List<String> getAllUsernames() {
//        for (User i : allUsers
//        ) {
//            allUsernames.add(i.getUserName());
//        }
//        return allUsernames;
//    }
}
