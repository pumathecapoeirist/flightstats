package database;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Trip {
    public City destination;
    public City origin;
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

    public City getDestination() {
        return destination;
    }

    public City getOrigin() {
        return origin;
    }

    public Date getDateOfSearch() {
        return dateOfSearch;
    }

    public void setDateOfSearch(Date dateOfSearch) {
        this.dateOfSearch = dateOfSearch;
    }

    public String toString() {
	String string = origin.name + "-" + destination.name + ", "
		+ getDepartDateString() + "-"
		+ getReturnDateString() + ", "
		+ getDateOfSearchString() ;
	return string;
    }

    public String getDepartDateString() {
	GregorianCalendar c = new GregorianCalendar();
	c.setTime(departDate);
	return c.get(Calendar.MONTH) + "/"
		+ c.get(Calendar.DATE) + "/"
		+ c.get(Calendar.YEAR);
    }
    

    public String getReturnDateString() {
	GregorianCalendar c = new GregorianCalendar();
	c.setTime(returnDate);
	return c.get(Calendar.MONTH) + "/"
		+ c.get(Calendar.DATE) + "/"
		+ c.get(Calendar.YEAR);
    }

    public String getDateOfSearchString() {
	GregorianCalendar c = new GregorianCalendar();
	c.setTime(dateOfSearch);
	return c.get(Calendar.MONTH) + "/"
		+ c.get(Calendar.DATE) + "/"
		+ c.get(Calendar.YEAR);
    }
}
