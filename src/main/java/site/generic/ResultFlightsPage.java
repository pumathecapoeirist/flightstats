package site.generic;

import java.math.BigDecimal;

import org.openqa.selenium.WebDriver;

import database.Trip;

public abstract class ResultFlightsPage {
    
    protected static final int DRIVER_TIME_WAIT = 30;
    protected WebDriver driver;

    public void setDriver(WebDriver driver) {
	this.driver = driver;
    }

    public WebDriver getDriver() {
	return this.driver;
    }
    
    public abstract BigDecimal getLowerPrice(Trip trip);

}
