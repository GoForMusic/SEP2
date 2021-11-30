package client.view.receptionist.customerList;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class CustomerListController implements ViewController {
    public ListView<HBox> customerList;
    private ViewHandler viewHandler;
    private CustomerListViewModel vm;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        vm = vmf.getCustomerListViewModel();
        customerList.setItems(vm.getCustomerList());
    }
}
