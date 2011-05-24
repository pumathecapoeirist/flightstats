package site.bingtravel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import site.generic.SearchFlightPage;

public class BingSearchFlightsPage extends SearchFlightPage {

    private static final String url = "http://www.bing.com/travel/";
    
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
    }
    
    @Override
    public void launchSearch() {
	ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
		DRIVER_TIME_WAIT);
	PageFactory.initElements(finder, this);

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
	element.click();
	element.click();

	// Check the title of the page
	System.out.println("Submitting page");

    }
}