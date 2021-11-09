package server.model.create;

import shared.utils.User;

import java.rmi.RemoteException;

public interface CreateHandler {
    boolean addUser(User user)  ;
    boolean doesUsernameExists(String username);
}
