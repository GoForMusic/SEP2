package client.core;

import client.model.login.LoginModel;
import client.model.login.LoginModelImpl;

public class ModelFactory {
    private ClientFactory clientFactory;
    private LoginModel loginModel;

    public ModelFactory(ClientFactory clientFactory){
        this.clientFactory=clientFactory;
    }

    public LoginModel getLoginModel() {
        if (loginModel == null) {
            loginModel = new LoginModelImpl(clientFactory.getLoginClient());
        }
        return loginModel;
    }
}
