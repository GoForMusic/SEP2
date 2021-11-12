package shared.utils.User;

import java.io.Serializable;

/**
 * User class
 * @author Adrian, Sachin
 * @version 2
 */
public abstract class User implements Serializable {
    private int employee_id;
    private String firstname;
    private String lastName;
    private String userName;
    private String password;


    /**
     * A 2 argument constructor
     * @param userName
     * @param password
     */
    public User(String userName, String password){
        this.employee_id =0;
        this.firstname="";
        this.lastName="";
        this.userName =userName;
        this.password=password;
    }

    /**
     * A 4 argument constructor, when the user will be created in the app and after pushed to the database
     * @param firstname
     * @param lastname
     * @param userName
     * @param password
     */
    public User (String firstname,String lastname,String userName,String password){
        this.employee_id =0;
        this.firstname=firstname;
        this.lastName=lastname;
        this.userName =userName;
        this.password=password;
    }

    /**
     * A 5 argument constructor, used only when is needed to show a list of users and the admin needs to see the specific userID from the database.
     * @param userID
     * @param firstname
     * @param lastname
     * @param userName
     * @param password
     */
    public User (int userID, String firstname,String lastname,String userName,String password){
        this.employee_id =userID;
        this.firstname=firstname;
        this.lastName=lastname;
        this.userName =userName;
        this.password=password;
    }



    /**
     * A get method for email address.
     * @return emailAddress
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
     * A get method for userID.
     * @return userID.
     */
    public int getEmployee_id(){
        return employee_id;
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
        return temp.getUserName().equals(userName) && temp.getPassword().equals(password);
    }
    private void validateUsername(String userName){
        if (userName.length()<4){
            throw new IllegalStateException("Username should consist more than 3 characters");
        }
        else if (userName.length() > 14){
            throw new IllegalStateException("Username should consist less than 15 characters");
        }
         char[] chars = userName.toCharArray();
        boolean hasDigits = false;
        for (char aChar : chars) {
            if (Character.isDigit(aChar)){
                hasDigits=true;
                break;
            }
        }


    }
}
