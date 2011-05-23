package site.generic;

import org.openqa.selenium.WebDriver;

import database.Trip;

public abstract class SearchFlightPage {
    
    protected volatile WebDriver driver;
        
    public abstract void launchSearch() ;
    

    public void setDriver(WebDriver driver) {
	this.driver = driver;
    }

    public WebDriver getDriver() {
	return this.driver;
    }
    
    public abstract void set(Trip trip);

}
