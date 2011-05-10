package kayak;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Main {
    public static void main(String[] args) {

	// Disable verbose error messages ?
	Logger logger = Logger.getLogger("");
	logger.setLevel(Level.SEVERE);

	// Creating a headless web driver
	DesiredCapabilities caps = DesiredCapabilities.firefox();
	caps.setJavascriptEnabled(true);
	WebDriver driver = new HtmlUnitDriver(caps);

	// Submit trip request
	KayakSearchFlightsPage searchPage = new KayakSearchFlightsPage(driver);
	searchPage.from("YUL").departDate("06/01/2011");
	searchPage.to("PAR").returnDate("07/01/2011");
	searchPage.launchSearch();

	// Get lowest price
	KayakResultsFlightsPage resultPage = new KayakResultsFlightsPage(
		searchPage);
	resultPage.getLowerPrice();

	// Close the browser
	driver.quit();
    }
}
