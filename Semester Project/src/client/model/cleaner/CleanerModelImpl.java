package client.model.cleaner;

import client.networking.cleaner.CleanerInfoClient;
import shared.utils.User.Cleaner;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class CleanerModelImpl implements CleanerModel{

    private CleanerInfoClient client;

    public CleanerModelImpl(CleanerInfoClient cleanerInfoClient)
    {
        this.client = cleanerInfoClient;
    }

    @Override
    public void updateCleaner(Cleaner cleaner, String oldUsername) {
        client.updateCleaner(cleaner, oldUsername);

    }

    @Override
    public void removeCleaner(Cleaner cleaner) {
        client.removeCleaner(cleaner);

    }

    @Override
    public Cleaner getCleaner(String username) {
        return client.getCleaner(username);
    }

    @Override
    public ArrayList<Cleaner> getCleaners() {
        return client.getCleaners();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
