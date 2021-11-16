package client.view.customer.luxuryRoom;

import client.core.ModelFactory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;
import java.util.Locale;

public class LuxuryRoomViewModel {
    private ObjectProperty<LocalDate> dateFrom,dateTo;
    private ModelFactory modelFactory;

    public LuxuryRoomViewModel(ModelFactory modelFactory) {
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
