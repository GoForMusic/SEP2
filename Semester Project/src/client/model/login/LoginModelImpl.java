package client.model.login;

import client.networking.login.LoginClient;
import shared.utils.User.Admin;
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
    public String isLoginPossible(String username, String password) {
        User tempUser = null;
        try {
            tempUser = new Admin(username, password);
        } catch (Exception e) {
            return e.getMessage();
        }
        String result = client.isLoginPossible(tempUser);
        if (result.equals("Approved")) {
            this.user = tempUser;
        }
        return result;
    }
}
