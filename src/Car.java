import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Car {
	private StringProperty carID;
    private StringProperty chassis;
    private StringProperty date;
    private StringProperty listPrice;

	//**************************//
	//		Contractors			//
	//**************************//
	public Car(StringProperty id,StringProperty chasiss,StringProperty date,StringProperty listPrice) {
		this.carID = id;
		this.chassis = chasiss;
		this.date = date;
		this.listPrice = listPrice;
	}
	public Car(int id, String chasiss,String date,int listPrice) {
		this(new SimpleStringProperty(String.valueOf(id)),new SimpleStringProperty(chasiss),
				new SimpleStringProperty(date),new SimpleStringProperty(String.valueOf(listPrice)));
	}
	
	
	


	//----------------------------------------------------------------------------------------------
	//			setters & gettees
	//----------------------------------------------------------------------------------------------
	
	// chassis
    public void setchassis(String value) {
    	chassisProperty().set(value); 
    	}
    public String getchassis() { return chassisProperty().get(); }
    public StringProperty chassisProperty() { 
        if (chassis == null) 
        	chassis = new SimpleStringProperty(this, "chassis");
        return chassis; 
    }
    
    // CarID
    public void setcarID(String value) {
    	carIDProperty().set(value); 
    	}
    public String getcarID() { return carIDProperty().get(); }
    public StringProperty carIDProperty() { 
        if (carID == null) carID = new SimpleStringProperty(this, "CarID");
        return carID; 
    }
	
 // date
    public void setDate(String value) {
    	dateProperty().set(value); 
    	}
    public String getDate() { 
    	return dateProperty().get(); 
    	}
    public StringProperty dateProperty() { 
        if (date == null) 
        	date = new SimpleStringProperty(this, "date");
        return date; 
    }
}
