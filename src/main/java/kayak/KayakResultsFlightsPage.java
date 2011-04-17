package kayak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class KayakResultsFlightsPage {

    public final int DRIVER_TIME_WAIT = 30; // 30 seconds

    private KayakSearchFlightsPage searchOrigin;

    // This element appears when the Ajax request for search is over
    @SuppressWarnings("unused")
    @FindBy(id = "shareresultstd")
    private WebElement shareResults;

    // Lowest price using multiple airlines
    @FindBy(id = "abpMULT")
    private WebElement lowestPrice;

    public KayakResultsFlightsPage(KayakSearchFlightsPage searchOriginPage) {
	this.searchOrigin = searchOriginPage;
	WebDriver driver = KayakSearchFlightsPage.getDriver();
	ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
		DRIVER_TIME_WAIT);
	PageFactory.initElements(finder, this);
    }

    /**
     * Check the lowestPrice of the page
     */
    public void getLowerPrice() {
	System.out.println("Page lowest price is: " + lowestPrice.getText());
    }
}