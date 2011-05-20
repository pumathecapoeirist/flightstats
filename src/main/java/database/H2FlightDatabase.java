package database;

import java.sql.Connection;

import org.h2.jdbcx.JdbcConnectionPool;

public class H2FlightDatabase extends FligthDatabase {
    private Connection conn;
    private JdbcConnectionPool cp;

    public H2FlightDatabase() {
	super();
    }

    @Override
    public void open() {
	try {
	    cp = JdbcConnectionPool.create("jdbc:h2:test_database", "sa", "sa");
	    conn = cp.getConnection();
	    
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

}
