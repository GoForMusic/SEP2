package client.core;

import client.networking.LoginClient;
import client.networking.LoginClientImpl;

public class ClientFactory {
    private LoginClient loginClient;

    public LoginClient getLoginClient() {
        if (loginClient == null) {
            loginClient = new LoginClientImpl();
        }
        return loginClient;
    }
}
