package client.view.receptionist.customerList;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import shared.utils.User.Customer;
import shared.utils.User.User;

import java.util.ArrayList;
import java.util.Optional;

public class CustomerListController implements ViewController {
    public ListView<HBox> customerList;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;

        ArrayList<Customer> list = new ArrayList<>();
        list.add(new Customer("Adrian1","Militaru","adri1213","123456","adrian@test.com"));
        list.add(new Customer("Adrian2","Militaru2","testUsername1","1234","test@test.com"));
        setListDetails(list);
    }





    //TODO
    private void setListDetails(ArrayList<Customer> list)
    {

        customerList.getItems().clear();

        for(Customer item:list)
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
                    //refresh list
                }

            });
            HBox.setMargin(editButton,new Insets(0,5,0,0));
            hBox.getChildren().addAll(editButton,removeButton);
            customerList.getItems().add(hBox);
        }
    }



}
