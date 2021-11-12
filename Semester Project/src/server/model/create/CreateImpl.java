package server.model.create;

import server.database.Employee.EmployeeRepository;
import server.database.Employee.EmployeeRepositoryImpl;
import shared.utils.User.User;

import java.sql.SQLException;

/**
 * @author Sachin Baral
 * A model on a server side that sends data related to creating an account to the data access object
 */
public class CreateImpl implements CreateHandler{

    private EmployeeRepository employeeRepository;

//TODO initialize the employee repository

    @Override
    public boolean doesUsernameExists(String username) {


        // TODO deal with database
        return false;

    }

    @Override
    public String addUser(User user) {
        if (doesUsernameExists(user.getUserName())){
            return "User name already exists";
        }
        else{
            try {
                employeeRepository = new EmployeeRepositoryImpl();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            employeeRepository.insertEmployee(user);
            return "Approved";
        }
    }
}
