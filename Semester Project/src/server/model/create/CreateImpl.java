package server.model.create;

import server.database.Employee.EmployeeRepository;
import shared.utils.User.User;

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
            employeeRepository.insertEmployee(user);
            return "Approved";
        }
    }
}
