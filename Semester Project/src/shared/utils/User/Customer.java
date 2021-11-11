package shared.utils.User;

import java.io.Serializable;

/**
 * A child class that is extends of the User
 * @author Adrian
 * @version 1
 */
public class Customer extends User implements Serializable {
    private String email;

    /**
     * A 2 argument constructor
     * @param userName
     * @param password
     * @param email
     */
    public Customer(String userName, String password, String email){
        super(userName, password);
        this.email=email;
    }

    /**
     * A 4 argument constructor, when the user will be created in the app and after pushed to the database
     * @param firstname
     * @param lastname
     * @param userName
     * @param password
     * @param email
     */
    public Customer (String firstname,String lastname,String userName,String password, String email){
        super(firstname, lastname, userName, password);
        this.email=email;
    }

    /**
     * A 5 argument constructor, used only when is needed to show a list of users and the admin needs to see the specific userID from the database.
     * @param userID
     * @param firstname
     * @param lastname
     * @param userName
     * @param password
     */
    public Customer (int userID, String firstname,String lastname,String userName,String password, String email){
        super(userID, firstname, lastname, userName, password);
        this.email=email;
    }

    /**
     * A method that will return the employee type
     * @return "Cleaner"
     */
    @Override
    public String getEmployeeType() {
        return " ";
    }

    public String getEmail() {
        return email;
    }
}
