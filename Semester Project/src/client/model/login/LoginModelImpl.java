package client.model.login;

import client.networking.login.LoginClient;
import shared.utils.Request;

/**
 * @author Sachin
 * The model that deals with login in the system
 */
public class LoginModelImpl implements LoginModel {

    private LoginClient client;
    private String userName;
    private String userType;

    public LoginModelImpl(LoginClient loginClient) {
        this.client = loginClient;
    }

    @Override
    public Request login(String username, String password) {
        return client.login(username, password);
    }

    @Override
    public void setUsername(String userName) {

        this.userName = userName;
        System.out.println("Set username called .. username set to be :" + this.userName);
    }

    @Override
    public String getUsername() {
        System.out.println("get username called ,,, returned." + userName);
        return userName;
    }

    @Override
    public void setUserType(String userType) {
        this.userType=userType;
        System.out.println("UserType set as :"+this.userType);
    }

    @Override
    public String getUserType() {
        System.out.println("Returned usertype as "+userType);
        return userType;

    }
}
