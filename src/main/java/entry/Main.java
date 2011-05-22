package entry;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import database.FlightDatabaseFactory;
import database.FligthDatabase;
import database.Trip;

import site.bingtravel.BingResultsFlightsPage;
import site.bingtravel.BingSearchFlightsPage;
import site.generic.ResultFlightsPage;
import site.generic.SearchFactorySingleton;
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
	FligthDatabase fligthDatabase = FlightDatabaseFactory.makeH2FlightDatabase();
	
	Trip trip= fligthDatabase.getTrip(10);
	System.out.println("Trip:"+trip);
	SearchFactorySingleton searchFactory = SearchFactorySingleton.getInstance();
	searchFactory.launch(trip);
	
	// Close the browser
	searchFactory.closeAllWebPages();
    }
}
