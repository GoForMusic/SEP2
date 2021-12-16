package client.core;

import client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Sachin, Himal, Adrian, Marian, Emil
 * A class that deals with loading fxml files and loading stages.
 */

public class ViewHandler {
    private Scene customerMainView;
    private Scene receptionistMainView;
    private Scene loginScene;
    private Stage stage;
    private ViewModelFactory vmf;
    private Scene adminMainView;

    /**
     * A constructor that will initialize viewmodelfactory and stage
     */
    public ViewHandler(ViewModelFactory vmf, Stage stage) {
        this.vmf = vmf;
        this.stage = stage;
        stage.setResizable(false);
    }

    /**
     * A function that will start the stage on login app.
     * */
    public void start() {
        stage = new Stage();
        openLogin();
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

    /**
     * Opens the main view for admin
     */
    public void openAdminMainView() {
        if (adminMainView == null) {
            Parent root = loadFXML("../view/admin/mainView/AdminMainView.fxml");
            adminMainView = new Scene(root);
            stage.setTitle("Admin");
        }
        stage.setScene(adminMainView);
        stage.show();
    }

    /**
     * Opens the main view for receptionist
     */
    public void openReceptionistMainView() {
        if (receptionistMainView == null) {
            Parent root = loadFXML("../view/receptionist/mainView/MainViewReceptionist.fxml");
            receptionistMainView = new Scene(root);
            stage.setTitle("Receptionist");
        }
        stage.setScene(receptionistMainView);
        stage.show();

    }

    /**
     * Opens the main view for cleaner
     */
    public void openClenerMainView() {
        if (receptionistMainView == null) {
            Parent root = loadFXML("../view/cleaner/cleanerHomePage.fxml");
            receptionistMainView = new Scene(root);
            stage.setTitle("Receptionist");
        }
        stage.setScene(receptionistMainView);
        stage.show();

    }

    /**
     * Opens the view room
     */
    public Parent getViewRoom() {
        return loadFXML("../view/viewRoomsTypes/viewRoom.fxml");
    }

    /**
     * Opens the room list
     */
    public Parent getRoomListReceptionist() {
        return loadFXML("../view/receptionist/roomList/roomList.fxml");
    }

    /**
     * Opens the single room
     */
    public Parent getSingleRoom() {
        return loadFXML("../view/customer/singleRoom/SingleRoom.fxml");
    }

    /**
     * Opens the double room
     */
    public Parent getDoubleRoom() {
        return loadFXML("../view/customer/doubleBedroom/DoubleBedRoom.fxml");
    }

    /**
     * Opens the luxury room
     */
    public Parent getLuxuryRoom() {
        return loadFXML("../view/customer/luxuryRoom/LuxuryRoom.fxml");
    }

    /**
     * Opens the create admin account
     */
    public Parent getAdminCreateAccount() {
        return loadFXML("../view/admin/createAccount/CreateAccount.fxml");
    }

    /**
     * a private function that will loadFXML file
     */
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

    /**
     * Opens the bookRoom
     */
    public Parent getRoomList() {
        return loadFXML("../view/bookRooms/BookRoom.fxml");
    }

    /**
     * Opens the search reservation
     */
    public Parent getSearchReservation() {
        return loadFXML("../view/receptionist/searchReservation/SearchCustomerReservation.fxml");
    }


    /**
     * Opens customer list
     */
    public Parent getCustomerList() {
        return loadFXML("../view/receptionist/customerList/customerList.fxml");
    }

    /**
     * Opens the create customer account
     */
    public Parent getReceptionistCreateCustomerAccount() {
        return loadFXML("../view/receptionist/CreateCustomerAccount/CreateAccount.fxml");
    }

    /**
     * Opens the customer reservation
     */
    public Parent getReceptionistReservation() {
        return loadFXML("../view/receptionist/searchReservation/SearchCustomerReservation.fxml");
    }

    /**
     * Opens the edit reservation
     */
    public Parent getEditReservation() {
        return loadFXML("../view/receptionist/editReservation/EditReservation.fxml");
    }

    /**
     * Opens the chat view
     */
    public Parent getChatView(){
        return loadFXML("../view/chat/ChatRoom.fxml");
    }

    /**
     * Opens the customer overview
     */
    public Parent getCustomerOverview(){
        return loadFXML("../view/customer/overview/overview.fxml");
    }

    /**
     * Opens the account info
     */
    public Parent getCustomerAccountInfoView(){
        return loadFXML("../view/customer/profile/accountInformation.fxml");
    }

    /**
     * Opens the create room
     */
    public Parent getAdminCreateRoom() {
        return loadFXML("../view/admin/createARoom/CreateARoom.fxml");
    }
}
