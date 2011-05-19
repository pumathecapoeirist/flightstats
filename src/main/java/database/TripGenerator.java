package database;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import database.City.CityType;

public class TripGenerator {

    private static Vector<City> primaryCities;
    private static Vector<City> secondaryCities;
    private Vector<Trip> trips;

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

    public TripGenerator() {
	setCities();
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

    private Collection<Trip> generateTrips(City origin, City destination) {
	
	// TODO: Use maxTripDateSpan, etc.
	Calendar departDate = Calendar.getInstance();
	Calendar returnDate ;
	Calendar dateOfSearch;
	Collection<Trip> c;
	c.add(new Trip(origin,destination,departDate,returnDate,dateOfSearch));
	return c;
    }

    private void setCities() {
	primaryCities.add(new City("London ", "LON", CityType.PRIMARY, 15640));
	secondaryCities.add(new City("Bangkok ", "BKK", CityType.SECONDARY,
		10350));
	primaryCities.add(new City("Paris  ", "PAR", CityType.PRIMARY, 9700));
	secondaryCities.add(new City("Singapore ", "SIN", CityType.SECONDARY,
		9502));
	secondaryCities.add(new City("Hong Kong ", "HKG", CityType.SECONDARY,
		8139));
	primaryCities.add(new City("New York City", "NYC", CityType.PRIMARY,
		6219));
	secondaryCities
		.add(new City("Dubai ", "DBX", CityType.SECONDARY, 6120));
	primaryCities.add(new City("Rome ", "ROM", CityType.PRIMARY, 6033));
	secondaryCities
		.add(new City("Seoul ", "SEL", CityType.SECONDARY, 4920));
	primaryCities
		.add(new City("Barcelona ", "BCN", CityType.PRIMARY, 4695));
	primaryCities.add(new City("Dublin ", "DUB", CityType.PRIMARY, 4469));
	secondaryCities.add(new City("Bahrain ", "BAH", CityType.SECONDARY,
		4418));
	secondaryCities.add(new City("Shanghai ", "SHA", CityType.SECONDARY,
		4315));
	primaryCities.add(new City("Toronto ", "YTO", CityType.PRIMARY, 4160));
	secondaryCities.add(new City("Kuala Lumpur ", "KUL",
		CityType.SECONDARY, 4125));
	secondaryCities.add(new City("Istanbul ", "IST", CityType.SECONDARY,
		3994));
	primaryCities.add(new City("Madrid ", "MAD", CityType.PRIMARY, 3921));
	primaryCities
		.add(new City("Amsterdam ", "AMS", CityType.PRIMARY, 3901));
	secondaryCities
		.add(new City("Prague ", "PRG", CityType.SECONDARY, 3702));
	primaryCities.add(new City("Moscow ", "MOW", CityType.PRIMARY, 3695));
	secondaryCities.add(new City("Beijing ", "PEK", CityType.SECONDARY,
		3593));
	secondaryCities
		.add(new City("Vienna ", "VIE", CityType.SECONDARY, 3339));
	secondaryCities
		.add(new City("Taipei ", "TPE", CityType.SECONDARY, 3280));
	secondaryCities.add(new City("St.Petersburg ", "PIE",
		CityType.SECONDARY, 3200));
	primaryCities.add(new City("Cancun ", "CUN", CityType.PRIMARY, 3074));
	secondaryCities
		.add(new City("Macau ", "MFM", CityType.SECONDARY, 3072));
	primaryCities.add(new City("Venice ", "CVCE", CityType.PRIMARY, 2927));
	secondaryCities
		.add(new City("Warsaw ", "WAW", CityType.SECONDARY, 2925));
	primaryCities.add(new City("Mexico ", "MEX", CityType.PRIMARY, 2823));
	primaryCities.add(new City("Los Angeles ", "LAX", CityType.PRIMARY,
		2513));
	primaryCities.add(new City("Berlin ", "BER", CityType.PRIMARY, 2309));
	primaryCities.add(new City("Rio De Janeiro ", "RIO", CityType.PRIMARY,
		2185));
	secondaryCities.add(new City("Budapest ", "BUD", CityType.SECONDARY,
		2043));
	primaryCities.add(new City("San Francisco ", "SFO", CityType.PRIMARY,
		1993));
	primaryCities.add(new City("Miami ", "MIA", CityType.PRIMARY, 1972));
	primaryCities.add(new City("Munich ", "MUC", CityType.PRIMARY, 1925));
	secondaryCities.add(new City("Shenzen ", "SZX", CityType.SECONDARY,
		1904));
	primaryCities.add(new City("Milan ", "MIL", CityType.PRIMARY, 1902));
	primaryCities.add(new City("Sydney ", "SYD", CityType.PRIMARY, 1852));
	primaryCities.add(new City("Oahu/Honolulu ", "HNL", CityType.PRIMARY,
		1733));
	secondaryCities
		.add(new City("Cairo ", "CAI", CityType.SECONDARY, 1720));
	primaryCities.add(new City("Florence ", "FLR", CityType.PRIMARY, 1715));
	primaryCities.add(new City("Lisbon ", "LIS", CityType.PRIMARY, 1715));
	primaryCities
		.add(new City("Las Vegas ", "LAS", CityType.PRIMARY, 1647));
	secondaryCities.add(new City("Marrakesh ", "RAK", CityType.SECONDARY,
		1500));
	secondaryCities
		.add(new City("Tokyo ", "TYO", CityType.SECONDARY, 1467));
	secondaryCities.add(new City("Edinburgh (GB) ", "EDI",
		CityType.SECONDARY, 1338));
	primaryCities.add(new City("Manchester (GB) ", "MAN", CityType.PRIMARY,
		912));
	primaryCities.add(new City("Montreal ", "YUL", CityType.PRIMARY, 679));
    }

}
