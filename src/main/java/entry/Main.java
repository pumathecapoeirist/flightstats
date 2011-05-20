package entry;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import database.FlightDatabaseFactory;
import database.FligthDatabase;

import site.bingtravel.BingResultsFlightsPage;
import site.bingtravel.BingSearchFlightsPage;
import site.generic.ResultFlightsPage;
import site.generic.SearchFlightPage;
import site.kayak.KayakResultsFlightsPage;
import site.kayak.KayakSearchFlightsPage;

public class Main {
    public static void main(String[] args) {

	// Disable verbose error messages at warning level.
	// TODO: Implement a correct reporting system using the Logger
	Logger logger = Logger.getLogger("");
	logger.setLevel(Level.SEVERE);

	
	//Initializing database
	//FligthDatabase database = FlightDatabaseFactory.makeH2FlightDatabase();
	
	// Creating a headless web driver
	DesiredCapabilities caps = DesiredCapabilities.firefox();
	caps.setJavascriptEnabled(true);
//	WebDriver driver = new HtmlUnitDriver(caps);
	WebDriver driver = new FirefoxDriver();

	// Prepare trip request
	SearchFlightPage searchPage = new BingSearchFlightsPage();
	searchPage.setDriver(driver);
	searchPage.from("YUL").departDate("06/01/2011");
	searchPage.to("PAR").returnDate("07/10/2011");
	ResultFlightsPage resultPage = new BingResultsFlightsPage();
	resultPage.setDriver(driver);

	//Submit request
	searchPage.launchSearch();

	// Get lowest price
	resultPage.getLowerPrice();

	// Close the browser
	driver.quit();
    }
}
