package site.generic;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import database.Trip;
import site.bingtravel.*;
import site.kayak.KayakResultsFlightsPage;
import site.kayak.KayakSearchFlightsPage;
import utils.CircularLinkedList;

/**
 * @author rdjondo This class is an abstraction of the search and result
 *         retrieve sequence on travel sites
 */
public class SearchFactorySingleton {

    private static SearchFactorySingleton instance = null;

    private class FlightPagePair {
	public SearchFlightPage searchPage;
	public ResultFlightsPage resultPage;

	public FlightPagePair(SearchFlightPage searchPage,
		ResultFlightsPage resultPage) {
	    this.searchPage = searchPage;
	    this.resultPage = resultPage;
	}
    }

    private static CircularLinkedList<FlightPagePair> flightPagePairs;
    private Iterator<FlightPagePair> it;

    private SearchFactorySingleton() {
	FlightPagePair kayakpages = new FlightPagePair(
		new KayakSearchFlightsPage(), new KayakResultsFlightsPage());
	FlightPagePair bingpages = new FlightPagePair(
		new BingSearchFlightsPage(), new BingResultsFlightsPage());
	flightPagePairs = new CircularLinkedList<FlightPagePair>();

	// Creating a headless web driver
	DesiredCapabilities caps = DesiredCapabilities.firefox();
	caps.setJavascriptEnabled(true);
	//WebDriver driver = new HtmlUnitDriver(caps);
	WebDriver driver = new FirefoxDriver();

	flightPagePairs.add(kayakpages);
	//flightPagePairs.add(bingpages);

	it = flightPagePairs.iterator();

	for (int i = 0; i < flightPagePairLength(); i++) {
	    FlightPagePair f = it.next();
	    f.resultPage.setDriver(driver);
	    f.searchPage.setDriver(driver);
	}
    }

    public static SearchFactorySingleton getInstance() {
	if (instance == null) {
	    instance = new SearchFactorySingleton();
	}
	return instance;
    }

    public int flightPagePairLength() {
	return flightPagePairs.size();
    }

    public void launch(Trip trip) {
	FlightPagePair flightPagePair = it.next();
	
	flightPagePair.searchPage.set(trip);
	
	//Submit request
	flightPagePair.searchPage.launchSearch();

	// Get lowest price
	flightPagePair.resultPage.getLowerPrice();
    }

    public void closeAllWebPages() {

	for (int i = 0; i < flightPagePairLength(); i++) {
	    FlightPagePair f = it.next();
	    f.resultPage.getDriver().close();
	}
    }
}
