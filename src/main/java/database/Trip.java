package database;

import java.util.Date;

public class Trip {
    public City origin;
    public City destination;
    public Date departDate;
    public Date returnDate;
    public Date dateOfSearch;
    
    public Trip(City origin, City destination, Date departDate,
	    Date returnDate, Date dateOfSearch) {
	super();
	this.origin = origin;
	this.destination = destination;
	this.departDate = departDate;
	this.returnDate = returnDate;
	this.dateOfSearch = dateOfSearch;
    }

}
