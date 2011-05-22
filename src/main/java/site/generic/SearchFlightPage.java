package site.generic;

import org.openqa.selenium.WebDriver;

import database.Trip;

public class SearchFlightPage {
    
    protected static final int DRIVER_TIME_WAIT = 30;
    protected WebDriver driver;
    
    protected String origin;
    
    protected String destination;
    
    protected String departDate;
    
    protected String returnDate;
    
    public void launchSearch() {
    }
    

    public void setDriver(WebDriver driver) {
	this.driver = driver;
    }

    public WebDriver getDriver() {
	return this.driver;
    }

    public SearchFlightPage from(String origin) {
	this.origin = origin;
	return this;
    }

    public SearchFlightPage to(String destination) {
	this.destination = destination;
	return this;
    }

    public SearchFlightPage departDate(String departDate) {
	this.departDate = departDate;
	return this;
    }

    public SearchFlightPage returnDate(String returnDate) {
	this.returnDate = returnDate;
	return this;
    }
    
    public void set(Trip trip){
	this.origin = trip.getOrigin().code;
	this.destination = trip.getDestination().code;
	this.departDate = trip.getDepartDateString();
	this.returnDate = trip.getReturnDateString();
    }

}
