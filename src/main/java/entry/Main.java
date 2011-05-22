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

	
	//Initializing database
	FligthDatabase fligthDatabase = FlightDatabaseFactory.makeH2FlightDatabase();
	
	Trip trip= fligthDatabase.getTrip(10);
	System.out.println("Trip:"+trip);
	SearchFactorySingleton searchFactory = SearchFactorySingleton.getInstance();
	searchFactory.launch(trip);
	
	// Close the browser
	searchFactory.closeAllWebPages();
    }
}
