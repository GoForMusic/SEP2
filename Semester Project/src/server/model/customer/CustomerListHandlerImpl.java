package server.model.customer;

import server.database.createAccount.CreateDAOImpl;
import server.database.customer.CustomerDAO;
import server.database.customer.CustomerDAOImpl;
import shared.utils.User.Customer;

import java.util.ArrayList;

public class CustomerListHandlerImpl implements CustomerListHandler{

    private CustomerDAO customerDAO;

    public CustomerListHandlerImpl() {

        customerDAO= new CustomerDAOImpl();
    }

    @Override
    public void updateCustomer(Customer customer, String oldUsername) {
        customerDAO.updateCustomer(customer,oldUsername);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerDAO.removeCustomer(customer);
    }

    @Override
    public Customer getCustomer(String username) {
        return customerDAO.getCustomer(username);
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}
