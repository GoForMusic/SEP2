package client.model.cleaner;

import shared.utils.Subject;
import shared.utils.User.Cleaner;

import java.util.ArrayList;

public interface CleanerModel extends Subject {
    void updateCleaner(Cleaner cleaner, String oldUsername);
    void removeCleaner(Cleaner cleaner);
    Cleaner getCleaner(String username);
    ArrayList<Cleaner> getCleaners();
}
