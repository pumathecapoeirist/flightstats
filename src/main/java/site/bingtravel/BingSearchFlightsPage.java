package site.bingtravel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import database.Trip;

import site.generic.SearchFlightPage;

public class BingSearchFlightsPage extends SearchFlightPage {

    protected WebDriver driver;
    protected String origin;
    protected String destination;
    protected String departDate;
    protected String returnDate;
    private String url = "http://www.bing.com/travel/";
    
    @FindBy(id = "orig1Text")
    private WebElement originWeb;

    @FindBy(id = "dest1Text")
    private WebElement destinationWeb;
    
    @FindBy(id = "leave1")
    private WebElement departDateWeb;
    
    @FindBy(id = "return1")
    private WebElement returnDateWeb;

    @FindBy(id = "stops")
    private WebElement preferNonstopCheckBox;
    

    public BingSearchFlightsPage() {
	super();
    }
    
    @Override
    public void set(Trip trip){
	//this.origin = trip.getOrigin().getCode();
	//this.destination = trip.getDestination().getCode();
	this.departDate = trip.getDepartDateString();
	this.returnDate = trip.getReturnDateString();
    }
    
    @Override
    public void launchSearch() {

	if (origin == null || destination == null || departDate == null
		|| returnDate == null) {
	    System.out.println(" YOU NEED TO INITIALIZE THE FLIGHT FIRST! ");
	}
	

	// And now use this to visit the site
	driver.get(url);

	// Enter something to search for
	originWeb.clear();
	originWeb.sendKeys(origin);
	
	// Enter something to search for
	destinationWeb.clear();
	destinationWeb.sendKeys(destination);

	// Enter something to search for
	departDateWeb.clear();
	departDateWeb.sendKeys(departDate);
	
	// Enter something to search for
	returnDateWeb.clear();
	returnDateWeb.sendKeys(returnDate);
	
	//Uncheck NonstopCheckBox if checked (the box is check by default)
	String s = preferNonstopCheckBox.getAttribute("checked");
	if (s != null && s.equals("true")) {
	    preferNonstopCheckBox.click();
	}
	
	// Find the boutton input element by its id
	WebElement element = driver.findElement(By.id("submitBtn"));
	
	// Now submit the form. WebDriver will find the form for us from the
	// element
	element.submit();

	// Check the title of the page
	System.out.println("Submitting page");

    }

}