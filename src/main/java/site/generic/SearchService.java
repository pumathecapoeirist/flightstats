package site.generic;

/**
 * @author rdjondo
 * This class is an abstraction of the search and result
 * retrieve sequence on travel sites
 */
public class SearchService {
    private SearchFlightPage searchPage ;
    private ResultFlightsPage resultPage;
    
    public SearchService(SearchFlightPage searchPage,
	    ResultFlightsPage resultPage) {
	this.searchPage = searchPage;
	this.resultPage = resultPage;
    }
    
    public void launch(){
	
    }
}
