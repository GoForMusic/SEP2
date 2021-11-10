package shared.utils;

import java.io.Serializable;

/**
 * User class
 * @author Adrian, Sachin
 * @version 1
 */
public class User implements Serializable {
    private int userID;
    private String emailAddress;
    private String password;
    private String firstname;
    private String lastName;
    private String department;

    /**
     * A 2 argument constructor
     * @param emailAddress
     * @param password
     */
    public User(String emailAddress, String password){
        this.userID=0;
        this.firstname="";
        this.lastName="";
        this.emailAddress=emailAddress;
        this.password=password;
        this.department="";
    }

    /**
     * A 5 argument constructor, when the user will be created in the app and after pushed to the database
     * @param firstname
     * @param lastname
     * @param emailAddress
     * @param password
     * @param department
     */
    public User (String firstname,String lastname,String emailAddress,String password, String department){
        this.userID=0;
        this.firstname=firstname;
        this.lastName=lastname;
        this.emailAddress=emailAddress;
        this.password=password;
        this.department=department;
    }

    /**
     * A 6 argument constructor, used only when is needed to show a list of users and the admin needs to see the specific userID from the database.
     * @param userID
     * @param firstname
     * @param lastname
     * @param emailAddress
     * @param password
     * @param department
     */
    public User (int userID, String firstname,String lastname,String emailAddress,String password, String department){
        this.userID=userID;
        this.firstname=firstname;
        this.lastName=lastname;
        this.emailAddress=emailAddress;
        this.password=password;
        this.department=department;
    }



    /**
     * A get method for email address.
     * @return emailAddress
     */
    public String getEmailAddress() {

        return emailAddress;
    }

    /**
     * A get method for password.
     * @return password
     */
    public String getPassword() {

        return password;
    }

    /**
     * A get method for userID.
     * @return userID.
     */
    public int getUserID(){
        return userID;
    }

    /**
     * A get method for department.
     * @return department
     */
    public String getDepartment(){
        return department;
    }

    /**
     * A get method for first name
     * @return firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * A get method for last name
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * A get method for firstname and lastname
     * @return firstname and lastname
     */
    public String getFullName(){
        return firstname+" "+lastName;
    }

    /**
     * A boolean function to compare the User object with another one
     * @param obj the second object
     * @return true or false
     */
    public boolean equals(Object obj){
        if (!(obj instanceof User)){
            return false;
        }
        User temp =(User) obj;
        return temp.getEmailAddress().equals(emailAddress) && temp.getPassword().equals(password);
    }

    /**
     * A method that will return the details
     * @return user details
     */
    @Override
    public String toString() {
        return "User{" +
                "ID='" + userID + '\'' +
                "emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
