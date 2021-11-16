package client.view.customer.singleRoom;

import client.core.ModelFactory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class SingleRoomViewModel {
    private ModelFactory modelFactory;
    private ObjectProperty<LocalDate> dateFrom,dateTo;

    public SingleRoomViewModel(ModelFactory modelFactory) {
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
