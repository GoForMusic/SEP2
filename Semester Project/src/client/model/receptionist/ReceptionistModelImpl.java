package client.model.receptionist;

import client.networking.receptionist.ReceptionistInfoClient;
import shared.utils.User.Receptionist;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ReceptionistModelImpl implements ReceptionistModel {

    private ReceptionistInfoClient client;

    public ReceptionistModelImpl(ReceptionistInfoClient receptionistInfoClient) {
        this.client = receptionistInfoClient;
    }

    @Override
    public void updateReceptionist(Receptionist receptionist, String oldUserName) {
        client.updateReceptionist(receptionist, oldUserName);

    }

    @Override
    public void removeReceptionist(Receptionist receptionist) {
        client.removeReceptionist(receptionist);
    }

    @Override
    public Receptionist getReceptionist(String username) {
        return client.getReceptionist(username);
    }

    @Override
    public ArrayList<Receptionist> getReceptionists() {
        return client.getReceptionists();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
