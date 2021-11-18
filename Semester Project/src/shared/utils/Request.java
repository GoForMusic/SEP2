package shared.utils;

import java.io.Serializable;

/**
 * @author  Sachin Baral
 * The object used in communication between client and server...
 */
public class Request implements Serializable {
    private String type;
    private Object object;

    /**
     * A two argument-constructor
     * @param type the type of object / or the instruction to deal with the object
     * @param object the object to deal with
     */
    public Request(String type, Object object){
        this.type = type;
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public Object getObject() {
        return object;
    }
}
