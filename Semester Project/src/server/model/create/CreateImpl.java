package server.model.create;

import shared.utils.User;

public class CreateImpl implements CreateHandler{


    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean doesUsernameExists(String username) {
        return false;
    }
}
