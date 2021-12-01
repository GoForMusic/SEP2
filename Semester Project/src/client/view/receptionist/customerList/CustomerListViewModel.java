package client.view.receptionist.customerList;

import client.core.ModelFactory;
import client.model.customer.CustomerModel;
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

public class CustomerListViewModel {
    private ObservableList<HBox> customerList;

    private CustomerModel customerModel;

    public CustomerListViewModel(ModelFactory modelFactory) {
        this.customerModel = modelFactory.getCustomerModel();
        loadUsers();
    }

    private void loadUsers(){
        ArrayList<Customer> customers = customerModel.getCustomers();
        ArrayList<HBox> elements = new ArrayList<>();

        if(!customers.isEmpty()){
            for(Customer item: customers)
            {
                HBox hBox = new HBox();
                //add the item title and author as well the specific details
                Label label = new Label(item.getUserName() + " | " + item.getFullName() + " | "+ item.getEmail());
                label.setPrefWidth(450);
                hBox.getChildren().add(label);
                //add edit button
                Button editButton = new Button("Edit");
                editButton.getStyleClass().add("buttonGreen");

                //edit item button event handler using lambda method
                editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {

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
                        //remove User
                    }

                });
                HBox.setMargin(editButton,new Insets(0,5,0,0));
                hBox.getChildren().addAll(editButton,removeButton);
                elements.add(hBox);
            }
        }

        customerList = FXCollections.observableArrayList(elements);
    }


    ObservableList<HBox> getCustomerList(){
        return customerList;
    }

}
