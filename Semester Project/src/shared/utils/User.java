package shared.utils;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String password;
    private String firstname;
    private String lastName;

    public User(String userName, String password){
        this.userName=userName;
        this.password=password;
    }

    public User (String firstname,String lastname,String userName,String password){
        this.userName=userName;
        this.password=password;
        this.firstname=firstname;
        this.lastName=lastname;
    }

    public String getUserName() {
       return userName;
    }

    public String getPassword() {

        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullName(){
        return firstname+" "+lastName;
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
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
