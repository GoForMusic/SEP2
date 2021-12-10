package server.database.receptionist;

import shared.utils.User.Receptionist;

import java.util.ArrayList;

public interface ReceptionistDAO {
    void updateReceptionist(Receptionist receptionist, String oldUsername);
    void removeReceptionist(Receptionist receptionist);
    Receptionist getReceptionist(String username);
    ArrayList<Receptionist> getReceptionists();
}
