package database;

public class FlightDatabaseFactory {
    public static FligthDatabase makeH2FlightDatabase(){
	return new H2FlightDatabase();
    }
}
