package server.model.create;

import server.database.createAccount.CreateDAO;
import server.database.createAccount.CreateDAOImpl;
import shared.utils.Request;
import shared.utils.room.Room;

/**
 * @author Sachin Baral
 * A model on a server side that sends data related to creating an account to the data access object
 */
public class CreateImpl implements CreateHandler {

    //    private CustomerRepository customerRepository;
    private CreateDAO createDAO;


    public CreateImpl() {
        // TODO: 11/20/2021 implement singleton here
        createDAO= new CreateDAOImpl();
    }


    @Override
    public String addUser(String firstname, String lastname, String username, String password, String userType) {
       return createDAO.addUser(firstname, lastname, username, password, userType);
    }

}