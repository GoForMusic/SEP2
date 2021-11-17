package client.view.customer.singleRoom;

import client.core.ModelFactory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class SingleRoomViewModel {
    private ModelFactory modelFactory;
    private ObjectProperty<LocalDate> dateFrom, dateTo;

    public SingleRoomViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        initializeDates();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }

    private void initializeDates() {
        dateFrom = new SimpleObjectProperty<>();
        dateFrom.set(LocalDate.now());
        dateTo = new SimpleObjectProperty<>();
        dateTo.set(LocalDate.now());
    }
}