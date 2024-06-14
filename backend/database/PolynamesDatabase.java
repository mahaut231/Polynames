package database;

public class PolynamesDatabase extends MySQLDatabase{
    public PolynamesDatabase() throws Exception {
        super("localhost", 3306, "polynamesgr", "root", "");
    }
}
