package kayak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KayakSearchFlightsPage {

    private static WebDriver driver;
    private static final String kayakURL = "http://www.kayak.com";
    private String origin;
    private String destination;
    private String departDate;
    private String returnDate;

    public KayakSearchFlightsPage(WebDriver driver) {
	this.driver = driver;
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

	// And now use this to visit the site
	driver.get(kayakURL);

	// Find the text input element by its id
	WebElement element = driver.findElement(By.id("origin"));

	// Enter something to search for
	element.sendKeys(origin);

	// Find the text input element by its id
	element = driver.findElement(By.id("destination"));

	// Enter something to search for
	element.sendKeys(destination);

	// Find the text input element by its id
	element = driver.findElement(By.id("depart_date"));

	// Enter something to search for
	element.sendKeys(departDate);

	// Find the text input element by its id
	element = driver.findElement(By.id("return_date"));

	// Enter something to search for
	element.sendKeys(returnDate);

	// Now submit the form. WebDriver will find the form for us from the
	// element
	element.submit();

	// Check the title of the page
	System.out.println("Page title is: " + driver.getTitle());

	// Close the browser
	driver.quit();
    }
}