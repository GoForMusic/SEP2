package client.model.create;

import client.networking.create.CreateClient;
import shared.utils.User;

public class CreateImpl implements CreateModel {
    public CreateClient client;

    public CreateImpl(CreateClient client) {
        this.client = client;
    }

    /**
     *
     * @param username the username to be checked
     * @return
     */
    @Override
    public boolean isConnectionPossible(String username) {
       return client.isConnectionPossible(username);

    }


    @Override
    public String addUser(String firstname, String lastname, String username, String password) {
       return client.addUser(firstname, lastname, username, password);
    }
}
