package client;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Adrian, Sachin, Himal, Marian, Emil
 * A class that will prepare application for start
 */
public class App extends Application {
    private ClientFactory cf;
    private ModelFactory mf;
    private ViewModelFactory vmf;
    private ViewHandler viewHandler;

    /**
     * A function that will start the application
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        cf = new ClientFactory();
        mf = new ModelFactory(cf);
        vmf = new ViewModelFactory(mf);
        viewHandler= new ViewHandler(vmf,stage);
        viewHandler.start();
    }

    /**
     * A function that will react on closing the app
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        //TODO react on closing of the stage
    }
}
