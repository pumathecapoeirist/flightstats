package database;

import java.util.Calendar;

public class Trip {
    public City destination;
    public City origin;
    public Calendar departDate;
    public Calendar returnDate;
    public Calendar dateOfSearch;
    
    public Trip(City origin, City destination, Calendar departDate,
	    Calendar returnDate, Calendar dateOfSearch) {
	super();
	this.origin = origin;
	this.destination = destination;
	this.departDate = departDate;
	this.returnDate = returnDate;
	this.dateOfSearch = dateOfSearch;
    }

    public String toString() {
	String string = origin.name + "-" + destination.name + ", "
		+ departDate.getTime() + "-"
		+ returnDate.getTime() + ", "
		+ dateOfSearch.getTime() ;
	return string;
    }

}
