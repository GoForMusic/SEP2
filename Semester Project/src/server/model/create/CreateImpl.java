package server.model.create;

import shared.utils.User.User;

public class CreateImpl implements CreateHandler{


    @Override
    public boolean addUser(User user) {

        //TODO deal with the databse
        return false;
    }

    @Override
    public boolean doesUsernameExists(String username) {
        // TODO deal with database
        return false;

    }
}
