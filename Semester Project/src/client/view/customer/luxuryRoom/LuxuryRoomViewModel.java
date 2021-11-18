package client.view.customer.luxuryRoom;

import client.core.ModelFactory;
import client.model.viewRooms.ViewRoomsModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import shared.utils.RoomType;

import java.time.LocalDate;

public class LuxuryRoomViewModel {
    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private ModelFactory modelFactory;
    private ViewRoomsModel viewRoomsModel;

    public LuxuryRoomViewModel(ModelFactory modelFactory) {
        this.viewRoomsModel = modelFactory.getViewRoomsModel();
        initializeDates();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }

    public void searchRooms() {
        viewRoomsModel.searchRooms(dateFrom.get(), dateTo.get(), RoomType.LUXURY);
    }

    private void initializeDates() {
        dateFrom = new SimpleObjectProperty<>();
        dateFrom.set(LocalDate.now());
        dateTo = new SimpleObjectProperty<>();
        dateTo.set(LocalDate.now());
    }
}
