package kayak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Main {
  public static void main(String[] args) {
    WebDriver driver = new FirefoxDriver();
    KayakSearchFlightsPage k = new KayakSearchFlightsPage(driver);
    k.from("YUL").departDate("04/06/2011").to("PARIS").returnDate("05/06/2011");
    PageFactory.initElements(driver, k);
    k.launchSearch();
  }
}
