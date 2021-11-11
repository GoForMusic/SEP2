package server.model.login;

import server.database.Employee.EmployeeRepository;
import server.database.Employee.EmployeeRepositoryImpl;
import shared.utils.User.Admin;
import shared.utils.User.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginHandlerImpl implements LoginHandler {

    private List<User> allUsers;
    private List<String> allUsernames;
    private EmployeeRepository employeeRepository;

    public LoginHandlerImpl() {
        allUsers = new ArrayList<>();
        allUsernames = new ArrayList<>();
       // allUsers.add(new User("Sachin", "Baral", "sachin07", "sachin123"));
    }


    @Override
    public String isLoginPossible(User user){
        //need database
        //TODO deal with database

        String message=" ";

        try {
            message = employeeRepository.getEmployeeLogin("test","1234").getUserName();
        } catch (SQLException e) {
            message = e.getMessage();
        }
        return message;
    }

//    private List<String> getAllUsernames() {
//        for (User i : allUsers
//        ) {
//            allUsernames.add(i.getUserName());
//        }
//        return allUsernames;
//    }
}
