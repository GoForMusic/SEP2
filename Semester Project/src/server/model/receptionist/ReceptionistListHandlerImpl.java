package server.model.receptionist;

import server.database.receptionist.ReceptionistDAOImpl;
import shared.utils.User.Receptionist;

import java.util.ArrayList;

public class ReceptionistListHandlerImpl implements ReceptionistListHandler{

    private ReceptionistDAOImpl receptionistDAO;

    public ReceptionistListHandlerImpl()
    {
        receptionistDAO = new ReceptionistDAOImpl();
    }

    @Override
    public void updateReceptionist(Receptionist receptionist, String oldUsername) {
        receptionistDAO.updateReceptionist(receptionist, oldUsername);

    }

    @Override
    public void removeReceptionist(Receptionist receptionist) { receptionistDAO.removeReceptionist(receptionist);

    }

    @Override
    public Receptionist getReceptionist(String username) {
        return receptionistDAO.getReceptionist(username);
    }

    @Override
    public ArrayList<Receptionist> getReceptionists() {
        return receptionistDAO.getReceptionists();
    }
}
