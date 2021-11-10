package client.core;

import client.networking.login.LoginClient;
import client.networking.login.LoginClientImpl;
import client.networking.create.CreateClient;
import client.networking.create.CreateClientImpl;

/**
 * @author Sachin
 * The class that creates and stores all the clients
 */
public class ClientFactory {
    private LoginClient loginClient;
    private CreateClient createClient;



    public LoginClient getLoginClient() {
        if (loginClient == null) {
            loginClient = new LoginClientImpl();
        }
        return loginClient;
    }

    public CreateClient getCreateClient() {
        if (createClient == null) {
            createClient = new CreateClientImpl();
        }
        return createClient;
    }
}
