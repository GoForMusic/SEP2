package shared.utils;

import java.io.Serializable;

public class User implements Serializable {
    private int userID;
    private String emailAddress;
    private String password;
    private String firstname;
    private String lastName;
    private String departmant;

    public User(String emailAddress, String password){
        this.emailAddress=emailAddress;
        this.password=password;
    }

    public User (int userID, String firstname,String lastname,String emailAddress,String password, String departmant){
        this.userID = userID;
        this.emailAddress=emailAddress;
        this.password=password;
        this.firstname=firstname;
        this.lastName=lastname;
        this.departmant=departmant;
    }

    public String getEmailAddress() {

       return emailAddress;
    }

    public String getPassword() {

        return password;
    }

    public int getUserID(){
        return userID;
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
        return temp.getEmailAddress().equals(emailAddress) && temp.getPassword().equals(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + userID + '\'' +
                "emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + departmant + '\'' +
                '}';
    }
}
