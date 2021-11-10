package client.model.create;

import client.networking.create.CreateClient;

public class CreateImpl implements CreateModel {
    public CreateClient client;

    public CreateImpl(CreateClient client) {
        this.client = client;
    }

    @Override
    public boolean isConnectionPossible(String username) {
       return client.isConnectionPossible(username);

    }

    @Override
    public String addUser(String firstname, String lastname, String username, String password) {
       return client.addUser(firstname, lastname, username, password);
    }
}
