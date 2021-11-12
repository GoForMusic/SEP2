package client.core;

import client.view.ViewController;
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
    private Scene loginScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage= new Stage();
        openLogin();

    }

    public void openLogin() {
        if (loginScene==null){
            try {
                Parent root =loadFXML("../view/login/Login.fxml");
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
    private  Scene customerMainView;
    public void openCustomerMainView() {
        if (customerMainView==null){
            try {
                Parent root =loadFXML("../view/viewRooms/main.fxml");
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
}
