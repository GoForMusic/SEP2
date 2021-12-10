package client.networking.cleaner;

import shared.utils.User.Cleaner;

import java.util.ArrayList;

public interface CleanerInfoClient {
    void updateCleaner(Cleaner cleaner, String oldUserName);
    void removeCleaner(Cleaner cleaner);
    Cleaner getCleaner(String username);
    ArrayList<Cleaner> getCleaners();

}
