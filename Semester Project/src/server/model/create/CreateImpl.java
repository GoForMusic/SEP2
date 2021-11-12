package server.model.create;

import server.database.Employee.EmployeeRepository;
import shared.utils.User.User;

public class CreateImpl implements CreateHandler{

    private EmployeeRepository employeeRepository;

    @Override
    public boolean addUser(User user) {
        //add user linked to database
        employeeRepository.insertEmployee(user);
        return false;
    }

    @Override
    public boolean doesUsernameExists(String username) {
        // TODO deal with database
        return false;

    }
}
