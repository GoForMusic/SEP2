package client.core;

import client.view.ViewController;
import client.view.customer.mainView.CustomerHomePageController;
import javafx.fxml.FXMLLoader;
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

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        // openLogin();
        openCustomerMainView();

    }

    public void openLogin() {
        if (loginScene == null) {
            Parent root = loadFXML("../view/customer/viewRoom.fxml");
            loginScene = new Scene(root);
            stage.setTitle("Login");
        }
        stage.setScene(loginScene);
        stage.show();
    }




    public void openCustomerMainView() {
        if (customerMainView == null) {
            Parent root = loadFXML("../view/customer/mainView/customerHomePage.fxml");
            customerMainView = new Scene(root);
            stage.setTitle("Customer");
        }
        stage.setScene(customerMainView);
        stage.show();
    }


    public Parent getViewRoom()   {
        return loadFXML("../view/customer/viewRooms/viewRoom.fxml");
    }
    public Parent getSingleRoom()  {
        return loadFXML("../view/customer/singleRoom/customerSingleBedRoom.fxml");
    }
    public Parent getDoubleRoom(){
        return loadFXML("../view/customer/doubleBedroom/customerDoubleBedRoom.fxml");
    }
    public Parent getLuxuryRoom(){
        return loadFXML("../view/customer/luxuryRoom/customerLuxuryRoom.fxml");
    }
    private Parent loadFXML(String path)  {
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


    public CustomerHomePageController getMainController() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/mainView/customerHomePage.fxml)"));
        Parent root = loader.load();
        CustomerHomePageController ctrl = loader.getController();
        return ctrl;

    }

    public Parent getViewRoom() throws IOException {
        return loadFXML("../view/customer/viewRoom.fxml");
    }
    public Parent getSingleRoom() throws IOException {
        return loadFXML("../view/customer/customerSingleBedRoom.fxml");
    }
    public Parent getDoubleRoom(){
        return loadFXML()
    }





}
