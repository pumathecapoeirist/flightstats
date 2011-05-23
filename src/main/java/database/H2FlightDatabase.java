package database;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.jdbcx.JdbcConnectionPool;

public class H2FlightDatabase extends FligthDatabase {
    private Connection conn;
    private JdbcConnectionPool cp;

    public H2FlightDatabase() {
	// Init is set to false. Must call open to have init to true.
	super();
    }

    @Override
    public void open() {
	try {
	    cp = JdbcConnectionPool.create("jdbc:h2:test_database", "sa", "sa");
	    conn = cp.getConnection();
	    Statement stmt = conn.createStatement();
	    stmt.execute("SHOW TABLES");
	    ResultSet rs = stmt.getResultSet();

	    if (rs.last()) {
		Array array = rs.getArray(1);
		System.out.println(array);
		this.setInit(true);
	    } else {
		stmt.executeUpdate("CREATE TABLE trips"
		/* destination and origin are the cities code */
		+ "( origin CHAR(8)," + "destination CHAR(8),"
			+ "departdate DATE," + "returndate DATE,"
			+ "dateofsearch DATE," + "minprice SMALLINT)");
	    }

	} catch (Exception e) {
	    // TODO Auto-generated catch block. Use Logger
	    e.printStackTrace();
	}
    }

    @Override
    public void close() {
	try {
	    conn.close();
	    cp.dispose();
	} catch (Exception e) {
	    // TODO Auto-generated catch block. Use Logger
	    e.printStackTrace();
	}
    }

    @Override
    public void persistTrip(Trip trip) {
	String query = "INSERT INTO trips "
		+ "(origin, destination, departdate, returndate"
		+ "dateofsearch,minprice)" + " VALUES (" + trip.origin.code
		+ "," + trip.destination.code + "," + trip.departDate + ","
		+ trip.returnDate + "," + trip.dateOfSearch + ","
		+ trip.getMinPrice() + "," + ")";
	try {
	    Statement stmt = conn.createStatement();
	    stmt.executeUpdate(query);
	    ResultSet rs = stmt.getResultSet();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
