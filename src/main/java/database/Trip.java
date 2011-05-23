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
    private short minPrice;

    public Trip(City origin, City destination, Date departDate,
	    Date returnDate, Date dateOfSearch) {
	super();
	this.origin = origin;
	this.destination = destination;
	this.departDate = departDate;
	this.returnDate = returnDate;
	this.dateOfSearch = dateOfSearch;
	this.minPrice = Short.MAX_VALUE;
    }
    
    public short getMinPrice() {
	return minPrice;
    }
    
    public void setMinPrice(short minPrice) {
	this.minPrice = minPrice;
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
	return convertDateToString(departDate);
    }
    

    public String getReturnDateString() {
	return convertDateToString(returnDate);
    }

    public String getDateOfSearchString() {
	return convertDateToString(dateOfSearch);
    }
    
    private String convertDateToString(Date d){
	GregorianCalendar c = new GregorianCalendar();
	c.setTime(d);
	return ((c.get(Calendar.MONTH)+1) + "/"
		+ c.get(Calendar.DATE) + "/"
		+ c.get(Calendar.YEAR));
    }
}
