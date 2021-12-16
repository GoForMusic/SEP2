package client.networking.create;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.User.User;

import java.rmi.RemoteException;

/**
 * @author Sachin
 * A class that will used all the function from Create client interface
 */
public class CreateClientImpl implements CreateClient {
    private Server server;

    /**
     * A constructor that will initialize the RMI connection
     */
    public CreateClientImpl() {
        try {
            server = GetServer.getServerFromRmi();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * A function that add a user
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @param userType
     * @return a message
     */
    @Override
    public String addUser(String firstname, String lastname, String username, String password, String userType) {
        try {
            return server.getCreateAccountServer().addUser(firstname,lastname,username,password,userType);
        } catch (RemoteException e) {
            return "Cannot connect to server";
        }
    }
}
