package client.core;

import client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Sachin Baral
 * A class that deals with loading fxml files and loading stages.
 */

public class ViewHandler {
    private Scene customerMainView;
    private Scene loginScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf,Stage stage) {
        this.vmf = vmf;
        this.stage=stage;
        stage.setResizable(false);
    }

    public void start() {
      //  stage = new Stage();

       openLogin();
//        test();
       //  openCustomerMainView();
    }
    /**
     * Opens the login scene in a new Stage
     */
    public void openLogin() {
        if (loginScene == null) {
            Parent root = loadFXML("../view/login/Login.fxml");
            loginScene = new Scene(root);
            stage.setTitle("Login");
        }
        stage.setScene(loginScene);
        stage.show();
    }


    /**
     * Opens the main view for customers
     */
    public void openCustomerMainView() {
        if (customerMainView == null) {
            Parent root = loadFXML("../view/customer/mainView/customerHomePage.fxml");
            customerMainView = new Scene(root);
            stage.setTitle("Customer");
        }
        stage.setScene(customerMainView);
        stage.show();
    }

//    private void test(){
//        Parent root = getSingleRoom();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }


    public Parent getViewRoom() {
        return loadFXML("../view/customer/viewRoomsTypes/viewRoom.fxml");
    }

    public Parent getSingleRoom() {
        return loadFXML("../view/customer/singleRoom/SingleRoom.fxml");
    }

    public  Parent getDoubleRoom() {
        return loadFXML("../view/customer/doubleBedroom/DoubleBedRoom.fxml");
    }

    public Parent getLuxuryRoom() {
        return loadFXML("../view/customer/luxuryRoom/LuxuryRoom.fxml");
    }

    private Parent loadFXML(String path) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf);
        return root;
    }

    public Parent getRoomList() {
      return loadFXML("../view/customer/bookRooms/BookRoomBookRoom.fxml");
    }
}
