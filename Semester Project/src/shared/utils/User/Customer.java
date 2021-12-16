package shared.utils.User;

import java.io.Serializable;

/**
 * A child class that is extends of the User
 * @author Adrian
 * @version 1
 */
public class Customer extends User implements Serializable {
    /**
     * A 3 argument constructor
     * @param firstname
     * @param lastname
     * @param userName
     */
    public Customer(String firstname, String lastname, String userName){
        super(firstname, lastname,userName);

    }

    /**
     * A 4 argument constructor that creates a customer without the e-mail address
     * @param firstname
     * @param lastname
     * @param userName
     * @param password
     */
    public Customer (String firstname,String lastname,String userName,String password){
        super(firstname, lastname, userName, password);
    }

    /**
     * A method that will return the employee type
     * @return "Cleaner"
     */
    @Override
    public String getEmployeeType() {
        return " ";
    }
}
