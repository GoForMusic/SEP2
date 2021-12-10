package client.model.receptionist;

import shared.utils.Subject;
import shared.utils.User.Receptionist;

import java.util.ArrayList;

public interface ReceptionistModel extends Subject {
    void updateReceptionist(Receptionist receptionist, String oldUserName);
    void removeReceptionist(Receptionist receptionist);
    Receptionist getReceptionist(String username);
    ArrayList<Receptionist> getReceptionists();
}
