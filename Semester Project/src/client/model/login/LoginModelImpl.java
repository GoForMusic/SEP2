package client.model.login;

import client.networking.login.LoginClient;
import shared.utils.Request;
import shared.utils.User.Admin;
import shared.utils.User.Customer;
import shared.utils.User.User;

/**
 * @author Sachin
 * The model that deals with login in the system
 */
public class LoginModelImpl implements LoginModel {

    private LoginClient client;
    private User user;

    public LoginModelImpl(LoginClient loginClient) {
        this.client = loginClient;
    }


    @Override
    public Request login(String username, String password) {
       return client.login(username,password);
    }
}
