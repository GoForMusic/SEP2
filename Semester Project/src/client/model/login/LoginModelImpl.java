package client.model.login;

import client.networking.chat.ChatClient;
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
    private ChatClient chatClient;

    /**
     * A constructor that is initialized login client and chat client
     */
    public LoginModelImpl(LoginClient loginClient, ChatClient chatClient) {
        this.client = loginClient;
        this.chatClient=chatClient;

    }

    /**
     * A function that is doing login
     */
    @Override
    public Request login(String username, String password) {
        return client.login(username, password);
    }

    /**
     * A function that set username
     */
    @Override
    public void setUsername(String userName) {

        this.userName = userName;
        chatClient.setUsername(userName);
     //   System.out.println("Set username called .. username set to be :" + this.userName);
    }

    /**
     * A function that is returning username
     * @return username
     */
    @Override
    public String getUsername() {
        //System.out.println("get username called ,,, returned." + userName);
        return userName;
    }

    /**
     * A function that is set the user type
     */
    @Override
    public void setUserType(String userType) {
        this.userType=userType;
        System.out.println("UserType set as :"+this.userType);
    }

    /**
     * A function that is returning user type
     */
    @Override
    public String getUserType() {
        System.out.println("Returned usertype as "+userType);
        return userType;

    }
}
