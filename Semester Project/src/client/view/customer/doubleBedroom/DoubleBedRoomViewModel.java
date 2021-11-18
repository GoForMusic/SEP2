package client.view.customer.doubleBedroom;

import client.core.ModelFactory;
import client.model.viewRooms.ViewRoomsModel;
import javafx.beans.property.*;
import shared.utils.RoomType;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 * The view model that deals with the double room
 */
public class DoubleBedRoomViewModel {

    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private ViewRoomsModel viewRoomsModel;
    private StringProperty description;
    private DoubleProperty pricePerNight;

    public DoubleBedRoomViewModel(ModelFactory modelFactory) {
        this.viewRoomsModel = modelFactory.getViewRoomsModel();
        initializeData();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }
    private void getDescriptionByCategory(){
        String description = viewRoomsModel.getDescriptionByCategory(RoomType.DOUBLE);
        this.description.set(description);
    }

    /**
     *Passes the dates and rooms to the model
     */
    public void searchRooms() {
        viewRoomsModel.searchRooms(dateFrom.get(), dateTo.get(), RoomType.DOUBLE);
    }

    public StringProperty getDescription() {
        return description;
    }

    public DoubleProperty getPricePerNight() {
        return pricePerNight;
    }

    private void initializeData() {
        dateFrom = new SimpleObjectProperty<>();
        dateFrom.set(LocalDate.now());
        dateTo = new SimpleObjectProperty<>();
        dateTo.set(LocalDate.now());
        description = new SimpleStringProperty();
        pricePerNight = new SimpleDoubleProperty();
    }
}
