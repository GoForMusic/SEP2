package client.view.customer.doubleBedroom;

import client.core.ModelFactory;
import client.model.viewRooms.ViewRoomsModel;
import javafx.beans.property.*;
import shared.utils.room.RoomType;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 * The view model that deals with the double room
 */
public class DoubleBedRoomViewModel {

    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private ViewRoomsModel viewRoomsModel;
    private StringProperty description;
    private DoubleProperty price;

    public DoubleBedRoomViewModel(ModelFactory modelFactory) {
        this.viewRoomsModel = modelFactory.getViewRoomsModel();
        initializeData();
//        getDescriptionByCategory();
//        getPriceByCategory();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }

    private void getDescriptionByCategory() {
        String description = viewRoomsModel.getDescriptionByCategory(RoomType.DOUBLE);
        this.description.set(description);
    }

    private void getPriceByCategory() {
        double price = viewRoomsModel.getPriceByCategory(RoomType.DOUBLE);
        this.price.set(price);
    }

    /**
     * Passes the dates and rooms to the model
     */
    public void searchRooms() {
        viewRoomsModel.searchRooms(dateFrom.get(), dateTo.get(), RoomType.DOUBLE);
    }

    public StringProperty getDescription() {
        return description;
    }

    public DoubleProperty getPricePerNight() {
        return price;
    }
    private void initializeData() {
        dateFrom = new SimpleObjectProperty<>();
        dateFrom.set(LocalDate.now());
        dateTo = new SimpleObjectProperty<>();
        dateTo.set(LocalDate.now());
        description = new SimpleStringProperty();
        price = new SimpleDoubleProperty();
    }
}
