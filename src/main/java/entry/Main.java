package entry;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import site.generic.ResultFlightsPage;
import site.generic.SearchFlightPage;
import site.kayak.KayakResultsFlightsPage;
import site.kayak.KayakSearchFlightsPage;

public class Main {
    public static void main(String[] args) {

	// Disable verbose error messages ?
	Logger logger = Logger.getLogger("");
	logger.setLevel(Level.SEVERE);

	// Creating a headless web driver
	DesiredCapabilities caps = DesiredCapabilities.firefox();
	caps.setJavascriptEnabled(true);
	WebDriver driver = new HtmlUnitDriver(caps);

	// Prepare trip request
	SearchFlightPage searchPage = new KayakSearchFlightsPage(driver);
	searchPage.from("YUL").departDate("06/01/2011");
	searchPage.to("PAR").returnDate("07/01/2011");
	ResultFlightsPage resultPage = new KayakResultsFlightsPage(driver);

	// Submit request and retrieve results
	PageService kayakservice = new PageService(searchPage, resultPage);
	kayakservice.lauch();

	// Close the browser
	driver.quit();
    }
}
