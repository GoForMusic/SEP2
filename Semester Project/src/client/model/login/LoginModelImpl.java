package client.model.login;

import shared.utils.User;

public class LoginModelImpl implements LoginModel{


    @Override
    public boolean isConnectionPossible(String username) {
        return false;
    }

    @Override
    public String isLoginPossible(String username,String password) {
        return null;
    }
}
