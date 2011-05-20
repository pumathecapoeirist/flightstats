package site.kayak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import site.generic.SearchFlightPage;

public class KayakSearchFlightsPage extends SearchFlightPage {

    private static final String url = "http://www.kayak.com";
    
    @FindBy(id = "origin")
    private WebElement originWeb;

    @FindBy(id = "destination")
    private WebElement destinationWeb;
    
    @FindBy(id = "depart_date")
    private WebElement departDateWeb;
    
    @FindBy(id = "return_date")
    private WebElement returnDateWeb;

    @FindBy(id = "cbEXPEDIA_DFDCMP2")
    private WebElement expediaCheckBox;
    
    @FindBy(id = "prefer_nonstop")
    private WebElement preferNonstopCheckBox;
    
    @FindBy(id = "roundtrip")
    private WebElement roundTripRadio;

    public KayakSearchFlightsPage() {
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