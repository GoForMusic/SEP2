package client.view.customer.viewRooms;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.customer.mainView.CustomerHomePageController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewRoomController implements ViewController {

    private ViewHandler viewHandler;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private CustomerHomePageController customerHomePageController;
    @FXML
    private ImageView singleRoomImage;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        viewHandler = vh;
    }

    public void customerDoubleRoomClicked(ActionEvent actionEvent) {
        clearAnchorPane();
        anchorPane.getChildren().setAll(viewHandler.getDoubleRoom());
    }

    public void customerLuxuryRoomClicked(ActionEvent actionEvent) {
        clearAnchorPane();
        anchorPane.getChildren().setAll(viewHandler.getDoubleRoom());
    }

    @FXML
    private EventHandler<? super MouseEvent> customerSingleRoomClicked( ) throws IOException {
        clearAnchorPane();
        anchorPane.getChildren().setAll(viewHandler.getSingleRoom());
        return null;
    }

    private void clearAnchorPane() {
        anchorPane.getChildren().clear();
    }
}


