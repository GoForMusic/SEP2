package client.view.receptionist.CreateCustomerAccount;

import client.core.ModelFactory;
import client.model.create.CreateModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Locale;

public class ReceptionistCreateCustomerAccountViewModel {
    private StringProperty firstName, lastName, userName, password, errorLabel, userType;
    private ModelFactory modelFactory;
    private CreateModel createModel;


    public javafx.beans.property.StringProperty getFirstNameProperty() {
        return firstName;
    }

    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public StringProperty getUserNameProperty() {
        return userName;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    public StringProperty errorLabelProperty() {
        return errorLabel;
    }

    public ReceptionistCreateCustomerAccountViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        createModel = modelFactory.getCreateModel();
        initializeAllProperties();
    }

    private void initializeAllProperties() {

        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        errorLabel = new SimpleStringProperty();
    }

    public String createAccount() {
        if (userName.get() == null || userName.get().isEmpty()) {
            errorLabel.set("Username cannot be empty..");

        } else if (firstName.get() == null || firstName.get().isEmpty()
                || lastName.get().isEmpty() || lastName.get() == null) {
            errorLabel.set("First name and last name cannot be empty..");

        } else if (password.get() == null || password.get().isEmpty()) {
            errorLabel.set("Password cannot be empty..");

        } else {
            String response = createModel.addUser(firstName.get(),
                    lastName.get(), userName.get(), password.get(), userType.get().toUpperCase(
                            Locale.ROOT)
            );
            if (!response.equals("Approved")) {
                errorLabel.set(response);
                clearUsernameAndPassword();
            }
            return response;

        }
        clearAll();
        return null;

    }

    private void clearAll() {
        password.set(null);
        userName.set(null);
        firstName.set(null);
        lastName.set(null);
    }

    private void clearUsernameAndPassword() {
        password.set(null);
        userName.set(null);
    }
}
