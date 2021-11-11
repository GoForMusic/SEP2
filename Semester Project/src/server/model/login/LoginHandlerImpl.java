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
       // allUsers.add(new User("Sachin", "Baral", "sachin07", "sachin123"));
    }


    @Override
    public String isLoginPossible(User user) {
//        String username = user.getUsername();
//        String password = user.getPassword();
//        if (username.length() < 5 || username.length()>14){
//            return "Username must have more than four and less than fourteen characters";
//        }
//        else if (password.length()<5){
//            return "Password must contain more than five character";
//        }
//        else{
//            return "is login possible is called...";
//        }
//
//
//        //need database
//        //TODO deal with database
//
//        System.out.println("Login possible ??");
        return "this means the flow is working..";
//

    }

//    private List<String> getAllUsernames() {
//        for (User i : allUsers
//        ) {
//            allUsernames.add(i.getUserName());
//        }
//        return allUsernames;
//    }
}
