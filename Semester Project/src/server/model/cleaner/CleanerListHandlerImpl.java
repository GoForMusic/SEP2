package server.model.cleaner;

import server.database.cleaner.CleanerDAO;
import server.database.cleaner.CleanerDAOImpl;
import shared.utils.User.Cleaner;

import java.sql.SQLException;
import java.util.ArrayList;

public class CleanerListHandlerImpl implements CleanerListHandler{

    private CleanerDAO cleanerDAO;

    public CleanerListHandlerImpl() throws SQLException {
        cleanerDAO = new CleanerDAOImpl();
    }

    @Override
    public void updateCleaner(Cleaner cleaner, String oldUsername) {
        cleanerDAO.updateCleaner(cleaner, oldUsername);

    }

    @Override
    public void removeCleaner(Cleaner cleaner) {
        cleanerDAO.removeCleaner(cleaner);
    }

    @Override
    public Cleaner getCleaner(String username) {
        return cleanerDAO.getCleaner(username);
    }

    @Override
    public ArrayList<Cleaner> getCleaners() {
        return cleanerDAO.getCleaners();
    }
}
