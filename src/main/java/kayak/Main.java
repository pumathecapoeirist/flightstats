package kayak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class Main {
    public static void main(String[] args) {
    	
    //Creating a headless web driver
    DesiredCapabilities caps = DesiredCapabilities.firefox(); 
    caps.setJavascriptEnabled(true); 
    WebDriver driver = new HtmlUnitDriver(caps); 
    	
	//Submit trip request
	KayakSearchFlightsPage searchPage = new KayakSearchFlightsPage(driver);
	searchPage.from("YUL").departDate("04/06/2011");
	searchPage.to("NYC").returnDate("05/07/2011");
	searchPage.launchSearch();
	
	//Get lowest price
	KayakResultsFlightsPage resultPage = new KayakResultsFlightsPage(searchPage);
	resultPage.getLowerPrice();
	
	// Close the browser
	driver.quit();
    }
}
