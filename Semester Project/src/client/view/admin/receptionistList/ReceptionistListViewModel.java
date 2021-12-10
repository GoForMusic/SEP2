package client.view.admin.receptionistList;

import client.core.ModelFactory;
import client.model.receptionist.ReceptionistModel;
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
import shared.utils.User.Receptionist;

import java.util.ArrayList;
import java.util.Optional;

public class ReceptionistListViewModel  {

    private ObservableList<HBox> receptionistList;
    private BooleanProperty editReceptionist;
    private StringProperty firstName, lastName, username, password, errorLabel;
    private StringProperty oldUsernameStored;
    private ReceptionistListViewModel receptionistListViewModel;
    private ReceptionistModel receptionistModel;


    public ReceptionistListViewModel(ModelFactory modelFactory) {
        this.receptionistModel = modelFactory.getReceptionistModel();
        receptionistList = new SimpleListProperty<>();
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        errorLabel = new SimpleStringProperty();
        editReceptionist = new SimpleBooleanProperty();
        oldUsernameStored = new SimpleStringProperty();

    }
    public void updateReceptionist(Receptionist receptionist, String oldUsername)
    {
        receptionistModel.updateReceptionist(receptionist, oldUsername);
    }

    public BooleanProperty getEditReceptionist()
    {
        return editReceptionist;
    }

    public StringProperty getOldUsernameStored()
    {
        return oldUsernameStored;
    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public StringProperty getLastName() {
        return lastName;
    }

    public StringProperty getUsername() {
        return username;
    }

    public StringProperty getPassword() {
        return password;
    }

    public StringProperty getErrorLabel() {
        return errorLabel;
    }

    ObservableList<HBox> getReceptionistList(){return receptionistList;}

    public void loadReceptionists()
    {
        ArrayList<Receptionist> receptionists = receptionistModel.getReceptionists();
        ArrayList<HBox> elements = new ArrayList<>();

        if(!receptionists.isEmpty())
        {
            for(Receptionist item: receptionists)
            {
                HBox hBox = new HBox();
                //add the item title and author as well the specific details
                Label label = new Label(item.getUserName() + " | " + item.getFullName() + " | "+ item.getEmployeeType());
                label.setPrefWidth(450);
                hBox.getChildren().add(label);
                //add edit button
                Button editButton = new Button("Edit");
                editButton.getStyleClass().add("buttonGreen");

                //edit item button event handler using lambda method
                editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                    oldUsernameStored.setValue(item.getUserName());
                    editReceptionist.setValue(true);
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
                        receptionistModel.removeReceptionist(item);
                        receptionistList.remove(item);
                    }
                });
                HBox.setMargin(editButton,new Insets(0,5,0,0));
                hBox.getChildren().addAll(editButton,removeButton);
                elements.add(hBox);
            }
            receptionistList = FXCollections.observableArrayList(elements);
        }
    }
}
