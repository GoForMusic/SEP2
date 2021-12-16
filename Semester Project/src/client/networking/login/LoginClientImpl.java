package client.networking.login;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.Request;

/**
 * @author Sachin
 * A class that will implement all the functions from LoginClient interface
 */
public class LoginClientImpl implements LoginClient{

    private Server server;

    /**
     * A constructor that will initialize the RMI connection
     */
    public LoginClientImpl(){
      server = GetServer.getServerFromRmi();
    }


    /**
     * A function that will do the login
     * @param username
     * @param password
     * @return return a message or user connected
     */
    @Override
    public Request login(String username, String password) {
        try {
            return server.getLoginServer().isLoginPossible(username,password);
        } catch (Exception e){
            e.printStackTrace();
            return new Request("Cannot connect to server",null);
        }

    }
}
