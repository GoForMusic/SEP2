package client.model.login;

import client.networking.LoginClient;
import client.networking.LoginClientImpl;
import shared.utils.User;

public class LoginModelImpl implements LoginModel{

    private LoginClient client;
    private User user;

    public LoginModelImpl(LoginClient loginClient){
        this.client=loginClient;
    }


    @Override
    public boolean isConnectionPossible(String username) {
        return false;
    }

    @Override
    public String isLoginPossible(String username,String password) {
       User tempUser = new User(username,password);
       String result= client.isLoginPossible(tempUser);
       if (result.equals("Approved")){
           this.user=tempUser;
       }
       return result;
    }
}
