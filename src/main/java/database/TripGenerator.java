package database;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Vector;

import database.City.CityType;

/**
 * Genearates all necessary combinations of trips
 * 
 * @author puma
 * 
 */
public class TripGenerator {

    private Vector<City> primaryCities = new Vector<City>();

    private Vector<City> secondaryCities = new Vector<City>();
    private Vector<Trip> trips = new Vector<Trip>();

    /**
     * If departDateSpan = 30, at max the depart date searched will be done on
     * 30 days after today
     */
    private int departDateSpan;

    /**
     * If maxTripDateSpan = 10, at max the difference between the depart date
     * and the return date searched will be 10 days
     */
    private int maxTripDateSpan;

    /**
     * If minTripDateSpan = 5, at max the difference between the depart date and
     * the return date searched will be 5 days
     */
    private int minTripDateSpan;

    /**
     * Constructor with default values for the parameters
     * 
     * @param departDateSpan
     *            If departDateSpan = 30, at max the depart date searched will
     *            be done on 30 days after today
     * @param maxTripDateSpan
     *            If maxTripDateSpan = 10, at max the difference between the
     *            depart date and the return date searched will be 10 days
     * @param minTripDateSpan
     *            If minTripDateSpan = 5, at max the difference between the
     *            depart date and the return date searched will be 5 days
     */
    public TripGenerator() {
	super();
	departDateSpan = 90;
	maxTripDateSpan = 15;
	minTripDateSpan = 10;
	initSpans(departDateSpan, maxTripDateSpan, minTripDateSpan);
    }

    /**
     * Constructor with default values for the parameters
     * 
     * @param departDateSpan
     *            If departDateSpan = 30, at max the depart date searched will
     *            be done on 30 days after today
     * @param maxTripDateSpan
     *            If maxTripDateSpan = 10, at max the difference between the
     *            depart date and the return date searched will be 10 days
     * @param minTripDateSpan
     *            If minTripDateSpan = 5, at max the difference between the
     *            depart date and the return date searched will be 5 days
     */
    public TripGenerator(int departDateSpan, int maxTripDateSpan,
	    int minTripDateSpan) {
	super();
	initSpans(departDateSpan, maxTripDateSpan, minTripDateSpan);
    }

    private void initSpans(int departDateSpan, int maxTripDateSpan,
	    int minTripDateSpan) {
	this.departDateSpan = departDateSpan;
	this.maxTripDateSpan = maxTripDateSpan;
	this.minTripDateSpan = minTripDateSpan;

	setCities();
	setPrimaryTrips();
	setSecondaryTrips();
    }

    private boolean setPrimaryTrips() {
	boolean success = false;
	// Cannot compute primary trips if primary cities are not defined
	if (primaryCities == null || secondaryCities == null) {
	    return success;
	}

	for (City origin : primaryCities) {
	    for (City destination : primaryCities) {
		if (!origin.equals(destination)) {
		    trips.addAll(generateTrips(origin, destination));
		}
	    }
	}
	return success;
    }

    private boolean setSecondaryTrips() {
	boolean success = false;
	// Cannot compute primary trips if primary cities are not defined
	if (primaryCities == null || secondaryCities == null) {
	    return success;
	}

	for (City origin : primaryCities) {
	    for (City destination : secondaryCities) {
		trips.addAll(generateTrips(origin, destination));
	    }
	}
	return success;
    }

    private Collection<Trip> generateTrips(City origin, City destination) {
	// Max trip depart date is
	GregorianCalendar maxTripDepartDate = new GregorianCalendar();
	maxTripDepartDate.add(Calendar.DATE, departDateSpan);

	// Max trip return date is
	GregorianCalendar minTripReturnDate = new GregorianCalendar();
	GregorianCalendar maxTripReturnDate = new GregorianCalendar();
	maxTripReturnDate.add(Calendar.DATE, maxTripDateSpan);

	Collection<Trip> c = new Vector<Trip>();

	// Loop 1 fix the depart date (within the 90 days span) and sweep the
	// return date
	GregorianCalendar departDate = new GregorianCalendar();
	GregorianCalendar returnDate = new GregorianCalendar();
	GregorianCalendar dateOfSearch = new GregorianCalendar();
	for (departDate.add(Calendar.DATE, 1); departDate
		.compareTo(maxTripDepartDate) < 0; departDate.add(
		Calendar.DATE, 1)) {

	    // Loop2 sweep the return date within trip span
	    minTripReturnDate.setTime(departDate.getTime());
	    minTripReturnDate.add(Calendar.DATE, minTripDateSpan);

	    for (returnDate.setTime(minTripReturnDate.getTime()); returnDate
		    .compareTo(maxTripReturnDate) < 0; returnDate.add(
		    Calendar.DATE, 1)) {
		Trip trip = new Trip(origin, destination, departDate.getTime(),
			returnDate.getTime(), dateOfSearch.getTime());
		c.add(trip);

	    }
	}
	return c;
    }

    private void setCities() {
	primaryCities.add(new City("London", "LON", CityType.PRIMARY, 15640));
	secondaryCities.add(new City("Bangkok ", "BKK", CityType.SECONDARY,
		10350));
	primaryCities.add(new City("Paris", "PAR", CityType.PRIMARY, 9700));
	secondaryCities.add(new City("Singapore ", "SIN", CityType.SECONDARY,
		9502));
	secondaryCities.add(new City("Hong Kong", "HKG", CityType.SECONDARY,
		8139));
	primaryCities.add(new City("New York City", "NYC", CityType.PRIMARY,
		6219));
	secondaryCities.add(new City("Dubai", "DBX", CityType.SECONDARY, 6120));
	primaryCities.add(new City("Rome", "ROM", CityType.PRIMARY, 6033));
	secondaryCities.add(new City("Seoul", "SEL", CityType.SECONDARY, 4920));
	primaryCities.add(new City("Barcelona", "BCN", CityType.PRIMARY, 4695));
	primaryCities.add(new City("Dublin", "DUB", CityType.PRIMARY, 4469));
	secondaryCities.add(new City("Shanghai", "SHA", CityType.SECONDARY,
		4315));
	primaryCities.add(new City("Toronto", "YTO", CityType.PRIMARY, 4160));
	secondaryCities.add(new City("Istanbul", "IST", CityType.SECONDARY,
		3994));
	primaryCities.add(new City("Madrid", "MAD", CityType.PRIMARY, 3921));
	primaryCities.add(new City("Amsterdam", "AMS", CityType.PRIMARY, 3901));
	secondaryCities
		.add(new City("Prague", "PRG", CityType.SECONDARY, 3702));
	primaryCities.add(new City("Moscow", "MOW", CityType.PRIMARY, 3695));
	secondaryCities
		.add(new City("Beijing", "PEK", CityType.SECONDARY, 3593));
	secondaryCities
		.add(new City("Vienna", "VIE", CityType.SECONDARY, 3339));
	secondaryCities
		.add(new City("Taipei", "TPE", CityType.SECONDARY, 3280));
	secondaryCities.add(new City("St.Petersburg ", "PIE",
		CityType.SECONDARY, 3200));
    }

    Vector<Trip> getTrips() {
	return trips;
    }

}
