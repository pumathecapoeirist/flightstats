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

	int index = 10;
	Trip trip = fligthDatabase.getTripAt(index);
	System.out.println("Trip:" + trip);
	SearchFactorySingleton searchFactory = SearchFactorySingleton
		.getInstance();
	/*Convert to a short integer */
	short minPrice = (short) searchFactory.launch(trip);

	trip.setMinPrice(minPrice);
	// Close the browser
	searchFactory.closeAllWebPages();
    }
}
