package client.view.admin.cleanerList;

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
import shared.utils.User.Cleaner;

public class CleanerListController implements ViewController {
    public ListView<HBox> cleanerList;
    public Pane editCleanerInfo;
    public TextField textFieldFirstName;
    public TextField textFieldLastName;
    public TextField textFieldUsername;
    public TextField textFieldPassword;
    public Text errorLabel;
    private ViewHandler viewHandler;
    private CleanerListViewModel vm;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.viewHandler = vh;
        vm = vmf.getCleanerListViewModel();
        loadCleanerList();
        editCleanerInfo.visibleProperty().bindBidirectional(vm.getEditCleaner());
        textFieldFirstName.textProperty().bindBidirectional(vm.getFirstName());
        textFieldLastName.textProperty().bindBidirectional(vm.getLastName());
        textFieldUsername.textProperty().bindBidirectional(vm.getUsername());
        textFieldPassword.textProperty().bindBidirectional(vm.getPassword());
        errorLabel.textProperty().bindBidirectional(vm.getErrorLabel());
    }

    private void loadCleanerList()
    {
        vm.loadCleaners();
        cleanerList.setItems(vm.getCleanerList());
    }

    @FXML
    public void updateCleanerInfo(MouseEvent mouseEvent) {
        try{
            StringProperty oldUsername = new SimpleStringProperty();
            oldUsername.bindBidirectional(vm.getOldUsernameStored());
            Cleaner cleaner = new Cleaner(textFieldFirstName.getText(),textFieldLastName.getText(),textFieldUsername.getText(),textFieldPassword.getText());
            vm.updateCleaner(cleaner,oldUsername.get());
            CancelEditAction(mouseEvent);
        }catch (IllegalStateException e)
        {
            errorLabel.setText(e.getMessage());
        }
        loadCleanerList();
    }

    @FXML
    public void CancelEditAction(MouseEvent mouseEvent) {
        editCleanerInfo.setVisible(false);
    }
}
