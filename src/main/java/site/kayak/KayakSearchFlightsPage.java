package site.kayak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import site.generic.SearchFlightPage;

public class KayakSearchFlightsPage extends SearchFlightPage {

    private static final int DRIVER_TIME_WAIT = 30;
    private WebDriver driver;
    private static final String url = "http://www.kayak.com";
    
    @FindBy(id = "origin")
    private WebElement originWeb;
    private String origin;
    

    @FindBy(id = "destination")
    private WebElement destinationWeb;
    private String destination;
    
    @FindBy(id = "depart_date")
    private WebElement departDateWeb;
    private String departDate;
    
    @FindBy(id = "return_date")
    private WebElement returnDateWeb;
    private String returnDate;

    @FindBy(id = "cbEXPEDIA_DFDCMP2")
    WebElement expediaCheckBox;
    
    @FindBy(id = "prefer_nonstop")
    WebElement preferNonstopCheckBox;
    
    @FindBy(id = "roundtrip")
    WebElement roundTripRadio;

    public KayakSearchFlightsPage(WebDriver driver) {
	ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
		DRIVER_TIME_WAIT);
	PageFactory.initElements(finder, this);
	this.driver = driver;
    }

    public WebDriver getDriver() {
	return this.driver;
    }

    public KayakSearchFlightsPage from(String origin) {
	this.origin = origin;
	return this;
    }

    public KayakSearchFlightsPage to(String destination) {
	this.destination = destination;
	return this;
    }

    public KayakSearchFlightsPage departDate(String departDate) {
	this.departDate = departDate;
	return this;
    }

    public KayakSearchFlightsPage returnDate(String returnDate) {
	this.returnDate = returnDate;
	return this;
    }
    
    @Override
    public void launchSearch() {

	if (origin == null || destination == null || departDate == null
		|| returnDate == null) {
	    System.out.println(" YOU NEED TO INITIALIZE THE FLIGHT FIRST! ");
	}
	
	DefaultElementLocatorFactory elmntLocFac = new DefaultElementLocatorFactory(
		driver);
	PageFactory.initElements(elmntLocFac, this);

	// And now use this to visit the site
	driver.get(url);

	// Enter something to search for
	originWeb.sendKeys(origin);
	
	// Enter something to search for
	destinationWeb.sendKeys(destination);

	// Enter something to search for
	departDateWeb.sendKeys(departDate);
	
	// Enter something to search for
	returnDateWeb.sendKeys(returnDate);
	
	//Uncheck Expedia checkbox if checked (the box is check by default)
	String s = expediaCheckBox.getAttribute("checked");
	if (s != null && s.equals("true")) {
	    expediaCheckBox.click();
	}
	
	//Check Round Trip box if not checked (the box is check by default)
	s = roundTripRadio.getAttribute("selected");
	if (s != null && s.equals("false")) {
	    roundTripRadio.click();
	}
	
	//Uncheck NonstopCheckBox if checked (the box is check by default)
	s = preferNonstopCheckBox.getAttribute("checked");
	if (s != null && s.equals("true")) {
	    preferNonstopCheckBox.click();
	}
	
	// Find the boutton input element by its id
	WebElement element = driver.findElement(By.id("fdimgbutton"));
	
	// Now submit the form. WebDriver will find the form for us from the
	// element
	element.submit();

	// Check the title of the page
	System.out.println("Submitting page");

    }
}