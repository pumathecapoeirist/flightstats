package site.kayak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import site.generic.SearchFlightPage;

public class KayakSearchFlightsPage extends SearchFlightPage {

    private String url = "http://www.kayak.com";



    public KayakSearchFlightsPage() {
	super();
    }

    @Override
    public void launchSearch() {

	if (origin == null || destination == null || departDate == null
		|| returnDate == null) {
	    System.out.println(" YOU NEED TO INITIALIZE THE FLIGHT FIRST! ");
	}

	// And now use this to visit the site
	driver.get(url);

	    
	   WebElement originWeb;

	   WebElement destinationWeb;
	   
	   WebElement departDateWeb;
	   
	   WebElement returnDateWeb;
	// Enter something to search for
	originWeb = driver.findElement(By.id("origin"));
	originWeb.clear();
	originWeb.sendKeys(origin);

	// Enter something to search for
	destinationWeb = driver.findElement(By.id("destination"));
	destinationWeb.clear();
	destinationWeb.sendKeys(destination);

	// Enter something to search for
	departDateWeb = driver.findElement(By.id("depart_date"));
	departDateWeb.clear();
	departDateWeb.sendKeys(departDate);

	// Enter something to search for
	returnDateWeb = driver.findElement(By.id("return_date"));
	returnDateWeb.clear();
	returnDateWeb.sendKeys(returnDate);
	
	
	WebElement preferNonstopCheckBox;

	WebElement roundTripRadio;
	
	// Check Round Trip box if not checked (the box is check by default)
	roundTripRadio = driver.findElement(By.id("prefer_nonstop"));
	String s = roundTripRadio.getAttribute("selected");
	if (s != null && s.equals("false")) {
	    roundTripRadio.click();
	}

	// Uncheck NonstopCheckBox if checked (the box is check by default)
	preferNonstopCheckBox = driver.findElement(By.id("roundtrip"));
	s = preferNonstopCheckBox.getAttribute("checked");
	if (s != null && s.equals("true")) {
	    preferNonstopCheckBox.click();
	}

        WebElement expediaCheckBox = driver.findElement(By.id("cbEXPEDIA_DFDCMP2"));
        String s1 = expediaCheckBox.getAttribute("checked");
        expediaCheckBox.click();

	// Find the button input element by its id
	WebElement element = driver.findElement(By.id("fdimgbutton"));

	// Now submit the form. WebDriver will find the form for us from the
	// element
	element.submit();

	// Check the title of the page
	System.out.println("Submitting page");

    }
}