package client.view.customer.singleRoom;

import client.core.ModelFactory;
import javafx.beans.property.*;

import java.time.LocalDate;

public class SingleRoomViewModel {
    private ModelFactory modelFactory;
    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private StringProperty description;
    private DoubleProperty price;

    public SingleRoomViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        initializeValues();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }

    private void initializeValues() {
        dateFrom = new SimpleObjectProperty<>();
        dateFrom.set(LocalDate.now());
        dateTo = new SimpleObjectProperty<>();
        dateTo.set(LocalDate.now());
        description = new SimpleStringProperty();
        price = new SimpleDoubleProperty();
    }
}
