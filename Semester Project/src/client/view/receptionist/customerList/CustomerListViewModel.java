package client.view.receptionist.customerList;

import client.core.ModelFactory;
import client.model.customer.CustomerModel;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import shared.utils.User.Customer;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Adrian
 * A class that will process the date and prepare to be presented on the UI
 */
public class CustomerListViewModel {
    private ObservableList<HBox> customerList;
    private StringProperty firstName, lastName, username, password, errorLabel;
    private StringProperty oldUsernameStored;
    private BooleanProperty editCustomer;

    private CustomerModel customerModel;

    /**
     * A constructor that will initialize model factory
     * @param modelFactory
     */
    public CustomerListViewModel(ModelFactory modelFactory) {
        this.customerModel = modelFactory.getCustomerModel();

        customerList = new SimpleListProperty<>();
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        errorLabel = new SimpleStringProperty();
        editCustomer = new SimpleBooleanProperty();
        oldUsernameStored = new SimpleStringProperty();
    }

    /**
     * A function that will updateCustomer details
     * @param customer
     * @param oldUsername
     */
    public void updateCustomer(Customer customer, String oldUsername){
        customerModel.updateCustomer(customer,oldUsername);
    }

    /**
     * A function that will load users and set-up on a list
     */
    public void loadUsers(){
        ArrayList<Customer> customers = customerModel.getCustomers();
        ArrayList<HBox> elements = new ArrayList<>();

        if(!customers.isEmpty()){
            for(Customer item: customers)
            {
                HBox hBox = new HBox();
                //add the item title and author as well the specific details
                Label label = new Label(item.getUserName() + " | " + item.getFullName() + " | ");
                label.setPrefWidth(450);
                hBox.getChildren().add(label);
                //add edit button
                Button editButton = new Button("Edit");
                editButton.getStyleClass().add("buttonGreen");

                //edit item button event handler using lambda method
                editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                    oldUsernameStored.setValue(item.getUserName());
                    editCustomer.setValue(true);
                    firstName.setValue(item.getFirstname());
                    lastName.setValue(item.getLastName());
                    username.setValue(item.getUserName());
                    password.setValue(item.getPassword());
                });

                Button removeButton = new Button("Remove");
                removeButton.getStyleClass().add("buttonRed");
                //remove item button event handler using lambda method
                removeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent)->{

                    //Ask for a confirmation to delete the item, if the OK button was pressed the deletion process can start and save into file
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete the user\n("+item.getUserName()+") from the system?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.get()== ButtonType.OK)
                    {
                        customerModel.removeCustomer(item);
                        customerList.remove(item);
                    }
                });
                HBox.setMargin(editButton,new Insets(0,5,0,0));
                hBox.getChildren().addAll(editButton,removeButton);
                elements.add(hBox);
            }
            customerList = FXCollections.observableArrayList(elements);
        }
    }

    /**
     * A function that will return a temp username
     * @return temporary username
     */
    public StringProperty getOldUsernameStored()
    {
        return oldUsernameStored;
    }

    /**
     * A function that will return customer list
     * @return customer list
     */
    public ObservableList<HBox> getCustomerList(){
        return customerList;
    }

    /**
     * A function that is returning first name
     * @return first name
     */
    public StringProperty getFirstName() {
        return firstName;
    }

    /**
     * A function that is returning last name
     * @return last name
     */
    public StringProperty getLastName() {
        return lastName;
    }

    /**
     * A function that is returning username
     * @return username
     */
    public StringProperty getUsername() {
        return username;
    }

    /**
     * A function that is returning password
     * @return password
     */
    public StringProperty getPassword() {
        return password;
    }

    /**
     * A function that is returning error message
     * @return error message
     */
    public StringProperty getErrorLabel() {
        return errorLabel;
    }

    /**
     * A function that is returning edit customer
     * @return edit customer
     */
    public BooleanProperty getEditCustomer(){
        return editCustomer;
    }
}
