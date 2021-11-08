package shared.utils;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String password;

    public User(String userName, String password){
        this.userName=userName;
        this.password=password;
    }
    public User(String userName)
    {
        this.userName=userName;
        this.password=null;
    }

    public String getUserName() {

       return userName;
    }

    public String getPassword() {

        return password;
    }

    public boolean equals(Object obj){
        if (!(obj instanceof User)){
            return false;
        }
        User temp =(User) obj;
        return temp.getUserName().equals(userName) && temp.getPassword().equals(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
