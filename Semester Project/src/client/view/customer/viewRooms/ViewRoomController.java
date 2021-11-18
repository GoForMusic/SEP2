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


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        viewHandler = vh;
    }

    @FXML
    private EventHandler<? super MouseEvent> customerDoubleRoomClicked() {
        clearAnchorPane();
        anchorPane.getChildren().setAll(viewHandler.getDoubleRoom());
        return null;
    }

    @FXML
    private EventHandler<? super MouseEvent> customerSingleRoomClicked()  {
        clearAnchorPane();
        anchorPane.getChildren().setAll(viewHandler.getSingleRoom());
        return null;
    }
    @FXML
    private EventHandler<? super MouseEvent> customerLuxuryRoomClicked( )
    {
        clearAnchorPane();
        anchorPane.getChildren().setAll(viewHandler.getLuxuryRoom());
        return null;
    }

    private void clearAnchorPane() {
        anchorPane.getChildren().clear();
    }
}


