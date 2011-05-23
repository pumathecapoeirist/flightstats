package site.bingtravel;

import java.math.BigDecimal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import database.Trip;

import site.generic.ResultFlightsPage;

public class BingResultsFlightsPage  extends ResultFlightsPage{
    // This element appears when the Ajax request for search is over
    @SuppressWarnings("unused")
    @FindBy(id = "sb_pagS")
    private WebElement shareResults;

    // Lowest price found
    @FindBy(className = "cheapest")
    private WebElement lowestPriceNonStop;


    
    public BingResultsFlightsPage(){
	super();
    }

    /**
     * Check the lowestPrice of the page
     */
    @Override
    public BigDecimal getLowerPrice(Trip trip) {
	ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
		DRIVER_TIME_WAIT);
	PageFactory.initElements(finder, this);

	// Add lowestPrice after removing the $ character
	BigDecimal lowestPrice = new BigDecimal(lowestPriceNonStop.getText()
		.substring(1));
	System.out.println("Page lowest price is: " + lowestPrice);
	return lowestPrice;
    }
}
