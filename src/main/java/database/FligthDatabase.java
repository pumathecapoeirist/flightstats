package database;

import java.util.Vector;

public class FligthDatabase {

    private boolean isInit;

    private static Vector<Trip> trips = new Vector<Trip>();

    public FligthDatabase() {
	isInit = false;
	
	
	TripGenerator tripGenerator = new TripGenerator(90,15,10);
	trips = tripGenerator.getTrips();
	System.out.println("Number of trips" + trips.size());
    }

    public void open() {
    }

    public void close() {
    }

    public boolean isInit() {
	return isInit;
    }

    public Trip getTrip(int index){
	return trips.elementAt(index);
    }
    
    public int tripsSize(){
	return trips.size();
    }

}
