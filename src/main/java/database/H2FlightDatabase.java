package database;

import java.sql.Connection;

import org.h2.jdbcx.JdbcConnectionPool;

public class H2FlightDatabase extends FligthDatabase {
    private Connection conn;
    private JdbcConnectionPool cp;

    public H2FlightDatabase() {
	
    }

    @Override
    public void open() {
	try {
	    cp = JdbcConnectionPool.create("jdbc:h2:test_database", "sa", "sa");
	    conn = cp.getConnection();
	    conn.close();
	    cp.dispose();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public void close() {
	try {
	    conn.close();
	    cp.dispose();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public void isInit() {
	// TODO Need to verify if database is well initialised with proper tables
	// The database is unnormalised as possible and the tables are not connected
	// Table1: Clique_cities
	// Table2: Secondary_cities
	// Table3: Everything: Origin - Destination - Date1 - Date2 - WebEngine - 
	// Requests - Which date of the week is preferable for buying a ticket for this destination?
	// 
	
    }

}
