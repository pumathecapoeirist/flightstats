package site.kayak;

import java.math.BigDecimal;
import java.util.Vector;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import site.generic.ResultFlightsPage;

public class KayakResultsFlightsPage extends ResultFlightsPage {

    // This element appears when the Ajax request for search is over
    @SuppressWarnings("unused")
    @FindBy(id = "shareresultstd")
    private WebElement shareResults;

    // Lowest price among the non stop flights
    @FindBy(id = "abp0")
    private WebElement lowestPriceNonStop;

    // Lowest price among the one stop flights
    @FindBy(id = "abp1")
    private WebElement lowestPriceOneStop;

    // Lowest price among the more than one stop flights
    @FindBy(id = "abp2")
    private WebElement lowestPriceMoreStops;
    
    public KayakResultsFlightsPage(){
    }

    /**
     * Check the lowestPrice of the page
     */
    @Override
    public BigDecimal getLowerPrice() {
	ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
		DRIVER_TIME_WAIT);
	PageFactory.initElements(finder, this);
	
	Vector<String> lowPriceCandidate = new Vector<String>(3);

	// Add lowestPrice after removing the $ character
	lowPriceCandidate.add(lowestPriceNonStop.getText().substring(1));
	lowPriceCandidate.add(lowestPriceOneStop.getText().substring(1));
	lowPriceCandidate.add(lowestPriceMoreStops.getText().substring(1));

	BigDecimal lowestPrice = new BigDecimal(Integer.MAX_VALUE);
	
	for (String candidate : lowPriceCandidate) {
	    BigDecimal lowestPriceCandidate = new BigDecimal(candidate);
	    lowestPrice = lowestPrice.min(lowestPriceCandidate);
	}

	System.out.println("Page lowest price is: " + lowestPrice);
	return lowestPrice;
    }
}