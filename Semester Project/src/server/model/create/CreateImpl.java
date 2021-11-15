package server.model.create;

import server.database.Customer.CustomerRepository;
import server.database.Customer.CustomerRepositoryImpl;
import shared.utils.User.Customer;
import shared.utils.User.User;

import java.sql.SQLException;

/**
 * @author Sachin Baral
 * A model on a server side that sends data related to creating an account to the data access object
 */
public class CreateImpl implements CreateHandler {

    private CustomerRepository customerRepository;

    public CreateImpl() {
        try {
            customerRepository = new CustomerRepositoryImpl();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot connect to database");
        }
    }

    @Override
    public String addUser(User user) {
        if (doesUsernameExists(user.getUserName())) {
            return "User name already exists";
        } else {
            customerRepository.insertCustomer((Customer) user);
            return "Approved";
        }
    }

    private boolean doesUsernameExists(String username) {
        return customerRepository.doesUsernameExists(username);

    }
}