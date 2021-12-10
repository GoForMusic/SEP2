package client.view.admin.editRoomType;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import com.sun.javafx.scene.control.IntegerField;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import shared.utils.roomType.RoomType;

public class RoomTypeController implements ViewController {
    public ListView<HBox> roomTypeList;
    public Pane editRoomInfo;
    public TextField textFieldRoomType;
    public IntegerField integerFieldPrice;
    public TextField textFieldDescription;
    public Text errorLabel;
    private ViewHandler viewHandler;
    private RoomTypeViewModel vm;



    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        vm = vmf.getEditRoomTypeViewModel();
        loadRoomsList();
        editRoomInfo.visibleProperty().bindBidirectional(vm.getEditRoomType());
        textFieldRoomType.textProperty().bindBidirectional(vm.getRoomType());
        integerFieldPrice.valueProperty().bindBidirectional(vm.getPrice());
        textFieldDescription.textProperty().bindBidirectional(vm.getDescription());

    }

    private void loadRoomsList() {
        vm.loadRooms();
        roomTypeList.setItems(vm.getRoomTypeList());
    }

    @FXML
    public void updateRoomInfo(MouseEvent mouseEvent)
    {
        try{
            RoomType roomType = new RoomType(textFieldRoomType.getText(), integerFieldPrice.getValue(), textFieldDescription.getText());
            vm.updateRoomInfo(roomType);
            CancelEditAction(mouseEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadRoomsList();
    }

    @FXML
    private void CancelEditAction(MouseEvent mouseEvent) {
        editRoomInfo.setVisible(false);
    }
}
