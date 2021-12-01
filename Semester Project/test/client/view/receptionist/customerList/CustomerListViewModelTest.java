/**package client.view.receptionist.customerList;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.model.customer.CustomerModel;
import client.model.customer.CustomerModelImpl;
import client.networking.customer.CustomerInfoClient;
import client.networking.customer.CustomerInfoImpl;
import org.junit.jupiter.api.*;
import shared.utils.User.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerListViewModelTest {

    private CustomerListViewModel vm;

    @BeforeEach
    public void setup()
    {
        ClientFactory client = new ClientFactory();
        ModelFactory mf = new ModelFactory(client);
        CustomerInfoClient client1 = new CustomerInfoImpl();
        CustomerModel model = new CustomerModelImpl(client1);
        vm = new CustomerListViewModel(mf);
    }

    @Test
    public void updateUserBadUsernameDigitFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","adri","123","adrian@via.dk");
            vm.updateCustomer(client,"adri123");
        });
    }

    @Test
    public void updateUserBadUsernameLess4LengthFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","ad1","123","adrian@via.dk");
            vm.updateCustomer(client,"adri123");
        });
    }

    @Test
    public void updateUserBadUsernameGreat14LengthFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","abc1edsafghjuytr","123","adrian@via.dk");
            vm.updateCustomer(client,"adri123");
        });
    }

    @Test
    public void updateUserBadPasswordDigitFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","adri1","abcd","adrian@via.dk");
            vm.updateCustomer(client,"adri123");
        });
    }

    @Test
    public void updateUserBadPasswordLess4LengthFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","adri1","123","adrian@via.dk");
            vm.updateCustomer(client,"adri123");
        });
    }

    @Test
    public void updateUserBadUsernamePassword14LengthFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","adri1","asabdagdgf123414564980651619#$%","adrian@via.dk");
            vm.updateCustomer(client,"adri123");
        });
    }
}
 **/