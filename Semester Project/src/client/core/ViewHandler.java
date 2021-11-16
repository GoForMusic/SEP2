package client.core;

import client.view.ViewController;
import client.view.mainView.CustomerHomePageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
            try {
                Parent root = loadFXML("../view/customer/viewRoom.fxml");
                loginScene = new Scene(root);
                stage.setTitle("Login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(loginScene);
        stage.show();
    }


    // .. TODO look at this

    public void openCustomerMainView() {
        if (customerMainView == null) {
            try {
                Parent root = loadFXML("../view/mainView/customerHomePage.fxml");
                customerMainView = new Scene(root);
                stage.setTitle("Customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(customerMainView);
        stage.show();
    }


    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
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
