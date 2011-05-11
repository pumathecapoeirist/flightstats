package site.generic;

import org.openqa.selenium.WebDriver;

import site.kayak.KayakSearchFlightsPage;

public abstract class SearchFlightPage {

    public abstract void launchSearch();

    public abstract WebDriver getDriver();

    public abstract KayakSearchFlightsPage from(String origin);

    public abstract KayakSearchFlightsPage to(String destination);

    public abstract KayakSearchFlightsPage departDate(String departDate);

    public abstract KayakSearchFlightsPage returnDate(String returnDate);

}
