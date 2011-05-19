package database;

public class FligthDatabase {

    private boolean isInit;

    private TripGenerator trips;

    public FligthDatabase() {
	isInit = false;

    }

    public void open() {
    }

    public void close() {
    }

    public boolean isInit() {
	return isInit;
    }

}
