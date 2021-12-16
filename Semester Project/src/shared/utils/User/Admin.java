package shared.utils.User;

import java.io.Serializable;

/**
 * A child class that is extends of the User
 * @author Adrian
 * @version 1
 */
public class Admin extends User implements Serializable {
    private String userType;

    /**
     * A 3 argument constructor
     * @param firstname
     * @param userName
     * @param password
     */
    public Admin(String firstname, String userName, String password){
        super(firstname,userName, password);
        this.userType="Admin";
    }

    /**
     * A 4 argument constructor, when the user will be created in the app and after pushed to the database
     * @param firstname
     * @param lastname
     * @param userName
     * @param password
     */
    public Admin (String firstname,String lastname,String userName,String password){
        super(firstname, lastname, userName, password);
        this.userType="Admin";
    }

    /**
     * A method that will return the employee type
     * @return "Admin"
     */
    @Override
    public String getEmployeeType() {
        return userType;
    }
}
