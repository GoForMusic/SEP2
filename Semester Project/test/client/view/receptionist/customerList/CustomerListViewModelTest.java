package client.view.receptionist.customerList;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.model.customer.CustomerModel;
import client.model.customer.CustomerModelImpl;
import client.networking.customer.CustomerInfoClient;
import client.networking.customer.CustomerInfoImpl;
import org.junit.jupiter.api.*;

import shared.utils.User.Customer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Adrian
 * A test class
 */
class CustomerListViewModelTest {

    private CustomerListViewModel vm;

    /**
     * A function that will be executed before each other tests and initialize everthing
     */
    @BeforeEach
    public void setup()
    {
        ClientFactory client = new ClientFactory();
        ModelFactory mf = new ModelFactory(client);
        CustomerInfoClient client1 = new CustomerInfoImpl();
        CustomerModel model = new CustomerModelImpl(client1);
        vm = new CustomerListViewModel(mf);
    }

    /**
     * A function that will test the update user with a bad username digit format
     */
    @Test
    public void updateUserBadUsernameDigitFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","adri","123");
            vm.updateCustomer(client,"adri123");
        });
    }

    /**
     * A function that will test the update user with a bad username less 4 length format
     */
    @Test
    public void updateUserBadUsernameLess4LengthFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","ad1","123");
            vm.updateCustomer(client,"adri123");
        });
    }

    /**
     * A function that will test the update user with a bad username great than 14
     */
    @Test
    public void updateUserBadUsernameGreat14LengthFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","abc1edsafghjuytr","123");
            vm.updateCustomer(client,"adri123");
        });
    }

    /**
     * A function that will test user with bad password digit
     */
    @Test
    public void updateUserBadPasswordDigitFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","adri1","abcd");
            vm.updateCustomer(client,"adri123");
        });
    }

    /**
     * A function that will test user with password less 4 length
     */
    @Test
    public void updateUserBadPasswordLess4LengthFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","adri1","123");
            vm.updateCustomer(client,"adri123");
        });
    }

    /**
     * A function that will test user password greather than 14
     */
    @Test
    public void updateUserBadUsernamePassword14LengthFormat()
    {
        assertThrows(IllegalStateException.class, ()->
        {
            Customer client = new Customer("Adrian","Militaru","adri1","asabdagdgf123414564980651619#$%");
            vm.updateCustomer(client,"adri123");
        });
    }
}
