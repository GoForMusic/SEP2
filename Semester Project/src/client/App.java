package client;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private ClientFactory cf;
    private ModelFactory mf;
    private ViewModelFactory vmf;
    private ViewHandler viewHandler;
    @Override
    public void start(Stage stage) throws Exception {

        cf = new ClientFactory();
        mf = new ModelFactory(cf);
        vmf = new ViewModelFactory(mf);
        viewHandler= new ViewHandler(vmf,stage);
        viewHandler.start();
    }

    @Override
    public void stop() throws Exception {
        //TODO react on closing of the stage
    }
}
