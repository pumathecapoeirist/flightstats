package entry;

import java.util.logging.Level;
import java.util.logging.Logger;

import database.FlightDatabaseFactory;
import database.FligthDatabase;
import database.Trip;

import site.generic.SearchFactorySingleton;

public class Main {
    public static void main(String[] args) {

	// Disable verbose error messages at warning level.
	// TODO: Implement a correct reporting system using the Logger
	Logger logger = Logger.getLogger("");
	logger.setLevel(Level.SEVERE);

	// Initializing database
	FligthDatabase fligthDatabase = FlightDatabaseFactory
		.makeH2FlightDatabase();
	fligthDatabase.open();
	SearchFactorySingleton searchFactory = SearchFactorySingleton
		.getInstance();

	for (int index = 0; index < fligthDatabase.tripsSize(); index++) {

	    Trip trip = fligthDatabase.getTripAt(index);
	    System.out.println("Trip:" + trip);
	    /* Convert to a short integer */
	    short minPrice = (short) searchFactory.launch(trip);

	    trip.setMinPrice(minPrice);

	    // Persist the value found
	    fligthDatabase.persistTrip(trip);
	    long end = System.currentTimeMillis()+1000;
	    while(System.currentTimeMillis()<end);
	}
	// Close the browser
	searchFactory.closeAllWebPages();
    }
}
