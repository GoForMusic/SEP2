package client.view.admin.receptionistList;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import shared.utils.User.Receptionist;

public class ReceptionistListController implements ViewController {

    public ListView<HBox> receptionistList;
    public Pane editReceptionistInfo;
    public TextField textFieldFirstName;
    public TextField textFieldLastName;
    public TextField textFieldUsername;
    public TextField textFieldPassword;
    public Text errorLabel;
    private ViewHandler viewHandler;
    private ReceptionistListViewModel vm;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        vm = vmf.getReceptionistListViewModel();
        loadReceptionistList();
        editReceptionistInfo.visibleProperty().bindBidirectional(vm.getEditReceptionist());
        textFieldFirstName.textProperty().bindBidirectional(vm.getFirstName());
        textFieldLastName.textProperty().bindBidirectional(vm.getLastName());
        textFieldUsername.textProperty().bindBidirectional(vm.getUsername());
        textFieldPassword.textProperty().bindBidirectional(vm.getPassword());
        errorLabel.textProperty().bindBidirectional(vm.getErrorLabel());
    }


    private void loadReceptionistList()
    {
        vm.loadReceptionists();
        receptionistList.setItems(vm.getReceptionistList());
    }

    @FXML
    public void updateReceptionistInfo(MouseEvent mouseEvent) {
        try{
            StringProperty oldUsername = new SimpleStringProperty();
            oldUsername.bindBidirectional(vm.getOldUsernameStored());
            Receptionist receptionist = new Receptionist(textFieldFirstName.getText(),textFieldLastName.getText(),textFieldUsername.getText(),textFieldPassword.getText());
            vm.updateReceptionist(receptionist,oldUsername.get());
            CancelEditAction(mouseEvent);
        }catch (IllegalStateException e)
        {
            errorLabel.setText(e.getMessage());
        }
        loadReceptionistList();
    }

    @FXML
    public void CancelEditAction(MouseEvent mouseEvent) {
        editReceptionistInfo.setVisible(false);
    }
}
