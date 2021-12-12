package shared.utils.User;

import java.io.Serializable;

/**
 * User class
 * @author Adrian, Sachin
 * @version 3
 */
public abstract class User implements Serializable {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;

    /**
     * A 2 argument constructor
     * @param userName
     * @param password
     */
    public User(String userName, String password){
       validateUsername(userName);
       validatePassword(password);
        this.firstName="";
        this.lastName="";
        this.userName =userName;
        this.password=password;
    }

    /**
     * A 3 argument constructor
     * @param firstname
     * @param lastName
     * @param username
     */
    public User(String firstname,String lastName,String username){
        this.firstName=firstname;
        this.lastName=lastName;
        this.userName=username;
    }

    /**
     * A 4 argument constructor, when the user will be created in the app and after pushed to the database
     * @param firstname
     * @param lastname
     * @param userName
     * @param password
     */
    public User (String firstname,String lastname,String userName,String password){
        validateUsername(userName);
        validatePassword(password);
        this.firstName=firstname;
        this.lastName=lastname;
        this.userName =userName;
        this.password=password;
    }

    /**
     * A function that will return username
     * @return username
     */
    public String getUserName() {

        return userName;
    }

    /**
     * A get method for password.
     * @return password
     */
    public String getPassword() {

        return password;
    }

    /**
     * A abstract method that will return the userType.
     * @return userType in childclasses
     */
    public abstract String getEmployeeType();

    /**
     * A get method for first name
     * @return firstname
     */
    public String getFirstname() {
        return firstName;
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
        return firstName+" "+lastName;
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
        return temp.getUserName().equals(userName) && temp.getPassword().equals(password);
    }

    /**
     * A function that will validate username
     * @param username
     */
    private void validateUsername(String username){
        if (username.length()<4){
            throw new IllegalStateException("Username should consist more than 3 characters");
        }
        else if (username.length() > 14){
            throw new IllegalStateException("Username should consist less than 15 characters");
        }
        char[] chars = username.toCharArray();
        boolean hasDigits = false;
        for (char aChar : chars) {
            if (Character.isDigit(aChar)){
                hasDigits=true;
                break;
            }
        }
        if (!hasDigits){
            throw new IllegalStateException("Username should have at least one digit..");
        }
    }

    /**
     * A function that will validate password
     * @param password
     */
    private void validatePassword(String password){
        if (password.length()<4){
            throw new IllegalStateException("Password should consist more than 3 characters");
        }
        else if (password.length() > 14){
            throw new IllegalStateException("Password should consist less than 15 characters");
        }
        char[] chars = password.toCharArray();
        boolean hasDigits = false;
        for (char aChar : chars) {
            if (Character.isDigit(aChar)){
                hasDigits=true;
                break;
            }
        }
        if (!hasDigits){
            throw new IllegalStateException("Password should have at least one digit..");
        }
    }
}
