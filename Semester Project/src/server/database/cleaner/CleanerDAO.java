package server.database.cleaner;

import shared.utils.User.Cleaner;

import java.util.ArrayList;

public interface CleanerDAO {
    void updateCleaner(Cleaner cleaner, String oldUsername);
    void removeCleaner(Cleaner cleaner);
    Cleaner getCleaner(String username);
    ArrayList<Cleaner> getCleaners();

}
