package client.view.admin.cleanerList;

import client.core.ModelFactory;
import client.model.cleaner.CleanerModel;
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
import shared.utils.User.Cleaner;

import java.util.ArrayList;
import java.util.Optional;

public class CleanerListViewModel  {

    private ObservableList<HBox> cleanerList;
    private BooleanProperty editCleaner;
    private StringProperty firstName, lastName, username, password, errorLabel;
    private StringProperty oldUsernameStored;
    private CleanerListViewModel cleanerListViewModel;

    private CleanerModel cleanerModel;

    public CleanerListViewModel(ModelFactory modelFactory) {
        this.cleanerModel = modelFactory.getCleanerModel();

        cleanerList = new SimpleListProperty<>();
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        errorLabel = new SimpleStringProperty();
        editCleaner = new SimpleBooleanProperty();
        oldUsernameStored = new SimpleStringProperty();
    }

    public void updateCleaner(Cleaner cleaner, String oldUsername)
    {
        cleanerModel.updateCleaner(cleaner, oldUsername);
    }
    public BooleanProperty getEditCleaner()
    {
        return editCleaner;
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

    ObservableList<HBox> getCleanerList(){return cleanerList;}


    public void loadCleaners(){
        ArrayList<Cleaner> cleaners = cleanerModel.getCleaners();
        ArrayList<HBox> elements = new ArrayList<>();

        if(!cleaners.isEmpty())
        {
            for(Cleaner item: cleaners)
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
                    editCleaner.setValue(true);
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
                        cleanerModel.removeCleaner(item);
                        cleanerList.remove(item);
                    }
                });
                HBox.setMargin(editButton,new Insets(0,5,0,0));
                hBox.getChildren().addAll(editButton,removeButton);
                elements.add(hBox);
            }
            cleanerList = FXCollections.observableArrayList(elements);
        }

    }

}
