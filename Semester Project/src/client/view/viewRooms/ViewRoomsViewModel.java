package client.view.viewRooms;

import client.core.ModelFactory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 * The view model for viewing rooms
 */
public class ViewRoomsViewModel {
    private ModelFactory modelFactory;
    private ObjectProperty<LocalDate> dateFrom,dateTO;

    public ViewRoomsViewModel(ModelFactory modelFactory){
        this.modelFactory=modelFactory;
        dateFrom= new SimpleObjectProperty<>();
        dateTO = new SimpleObjectProperty<>();
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }
    public ObjectProperty<LocalDate> getDateTO(){
        return dateTO;
    }

    public void search() {
    }
}
