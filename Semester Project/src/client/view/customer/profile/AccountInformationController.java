package client.view.customer.profile;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;

public class AccountInformationController implements ViewController
{

  private ViewHandler viewHandler;
  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler=vh;

  }
}
