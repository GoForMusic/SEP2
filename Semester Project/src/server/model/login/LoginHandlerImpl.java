package server.model.login;

import shared.utils.User;

import java.util.ArrayList;
import java.util.List;

public class LoginHandlerImpl implements LoginHandler {

    private List<User> allUsers;
    private List<String> allUsernames;

    public LoginHandlerImpl() {
        allUsers = new ArrayList<>();
        allUsernames = new ArrayList<>();
        allUsers.add(new User("Sachin", "Baral", "sachin07", "sachin123"));
    }


    @Override
    public String isLoginPossible(User user) {
        //need database
        System.out.println("Login possible ??");
        return "is login possible is called...";

    }

//    private List<String> getAllUsernames() {
//        for (User i : allUsers
//        ) {
//            allUsernames.add(i.getUserName());
//        }
//        return allUsernames;
//    }
}
