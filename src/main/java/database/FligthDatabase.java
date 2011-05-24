package database;

import java.util.Vector;

public abstract class FligthDatabase {

    private boolean isInit;

    protected static Vector<Trip> trips = new Vector<Trip>();

    protected static int currentTripIndex;

    public FligthDatabase() {
	isInit = false;

	TripGenerator tripGenerator = new TripGenerator(90, 15, 10);
	trips = tripGenerator.getTrips();
	System.out.println("Number of trips :" + trips.size());
    }

    public abstract void open();

    public abstract void close();
    
    public abstract void persistTrip(Trip trip);

    public boolean isInit() {
	return isInit;
    }
    
    public void setInit(boolean isInit) {
	this.isInit =  isInit;
    }

    /**
     * Get trip at given index
     * @param index
     * @return
     */
    public Trip getTripAt(int index) {
	return trips.elementAt(index);
    }

    /**
     * Update trip at given index
     * 
     * @param index
     * @param trip
     */
    public void setTripAt(int index, Trip trip) {
	trips.setElementAt(trip, index);
    }

    public Vector<Trip> getTrips(int index) {
	return trips;
    }

    public int tripsSize() {
	return trips.size();
    }

}
