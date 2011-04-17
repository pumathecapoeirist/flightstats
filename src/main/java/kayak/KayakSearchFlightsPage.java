package kayak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class KayakSearchFlightsPage {

    private static WebDriver driver;
    private static final String kayakURL = "http://www.kayak.com";
    
    
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

    public KayakSearchFlightsPage(WebDriver driver) {
	KayakSearchFlightsPage.driver = driver;
    }

    public static WebDriver getDriver() {
	return driver;
    }

    public static String getKayakurl() {
	return kayakURL;
    }

    public String getOrigin() {
	return origin;
    }

    public String getDestination() {
	return destination;
    }

    public String getDepartDate() {
	return departDate;
    }

    public String getReturnDate() {
	return returnDate;
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

    public void launchSearch() {

	if (origin == null || destination == null || departDate == null
		|| returnDate == null) {
	    System.out.println(" YOU NEED TO INITIALIZE THE FLIGHT FIRST! ");
	}
	
	DefaultElementLocatorFactory elmntLocFac = new DefaultElementLocatorFactory(
		driver);
	PageFactory.initElements(elmntLocFac, this);

	// And now use this to visit the site
	driver.get(kayakURL);

	// Enter something to search for
	originWeb.sendKeys(origin);
	
	// Enter something to search for
	destinationWeb.sendKeys(destination);

	// Enter something to search for
	departDateWeb.sendKeys(departDate);
	
	// Enter something to search for
	returnDateWeb.sendKeys(returnDate);
	
	//Uncked Expedia box that is checked by default
	String s = expediaCheckBox.getAttribute("checked");
	if (s.equals("true")) {
	    expediaCheckBox.click();
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