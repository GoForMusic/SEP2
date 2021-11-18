package client.view.customer.doubleBedroom;

import client.core.ModelFactory;
import client.model.viewRooms.ViewRoomsModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import shared.utils.RoomType;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 * The view model that deals with the double room
 */
public class DoubleBedRoomViewModel {

    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private ViewRoomsModel viewRoomsModel;

    public DoubleBedRoomViewModel(ModelFactory modelFactory) {
        this.viewRoomsModel = modelFactory.getViewRoomsModel();
        initializeDates();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }

    /**
     *Passes the dates and rooms to the model
     */
    public void searchRooms() {
        viewRoomsModel.searchRooms(dateFrom.get(), dateTo.get(), RoomType.DOUBLE);
    }

    private void initializeDates() {
        dateFrom = new SimpleObjectProperty<>();
        dateFrom.set(LocalDate.now());
        dateTo = new SimpleObjectProperty<>();
        dateTo.set(LocalDate.now());
    }
}
