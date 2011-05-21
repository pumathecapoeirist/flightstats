package site.generic;

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
    private CircularLinkedList.CircularListIterator<FlightPagePair> it;

    private SearchFactorySingleton() {
	FlightPagePair kayakpages = new FlightPagePair(
		new KayakSearchFlightsPage(), new KayakResultsFlightsPage());
	FlightPagePair bingpages = new FlightPagePair(
		new BingSearchFlightsPage(), new BingResultsFlightsPage());
	flightPagePairs = new CircularLinkedList<SearchFactorySingleton.FlightPagePair>();
	flightPagePairs.add(bingpages);
	flightPagePairs.add(kayakpages);
	it =  flightPagePairs.iterator();
    }

    public static SearchFactorySingleton getInstance() {
	if (instance == null) {
	    instance = new SearchFactorySingleton();
	}
	return instance;
    }
    
    public int flightPagePairLength(){
	return flightPagePairs.size();
    }
    
    public void launch(Trip trip){
	FlightPagePair flightPagePair = it.next();
	flightPagePair.searchPage.set(trip);
    }
}
