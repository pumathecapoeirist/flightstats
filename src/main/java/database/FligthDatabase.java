package database;

public abstract class FligthDatabase {
    
    /**
     * Clique as the graphs
     */
    static final String CLIQUE_CITIES[] = {
	"PAR",
	"YUL",
	"NYC"
    };
    

    static final String SECONDARY_CITIES[] = {
	"PEK",
	"TYO",
	"SIN"
    };
    
    abstract public void open();
    abstract public void close();
    abstract public void isInit();
}
