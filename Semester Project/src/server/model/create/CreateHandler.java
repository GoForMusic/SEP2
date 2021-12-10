package server.model.create;

import shared.utils.Request;
import shared.utils.User.User;
import shared.utils.room.Room;

public interface CreateHandler {

    String addUser(String firstname, String lastname, String username, String password, String userType);

}
