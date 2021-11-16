package client.view.customer.doubleBedroom;

import client.core.ModelFactory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class DoubleBedRoomViewModel {

    private ObjectProperty<LocalDate> dateFrom,dateTo;
    private ModelFactory modelFactory;

    public DoubleBedRoomViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        dateFrom= new SimpleObjectProperty<>();
        dateTo = new SimpleObjectProperty<>();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }
    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }
}
