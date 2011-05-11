package entry;

import site.generic.ResultFlightsPage;
import site.generic.SearchFlightPage;

public class PageService {
    
    SearchFlightPage searchPage;
    ResultFlightsPage resultPage;
    
    public PageService(SearchFlightPage searchPage,ResultFlightsPage resultPage) {
	this.searchPage = searchPage;
	this.resultPage = resultPage;
    }
    
    public void lauch() {
	
	//Submit request
	searchPage.launchSearch();

	// Get lowest price
	resultPage.getLowerPrice();
    }

}
