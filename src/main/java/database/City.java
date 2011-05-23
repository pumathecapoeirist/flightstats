package database;

public class City {

    public static enum CityType {
	PRIMARY, SECONDARY
    };

    public String name;
    public String code;
    public CityType type;
    public int numberVisitor;

    public City(String name, String code, CityType type, int numberVisitor) {
	this.name = name;
	this.code = code;
	this.type = type;
	this.numberVisitor = numberVisitor;
    }

}