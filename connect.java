package mainten;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aly
 */
public class connect {

    String db = "";
    public Connection conn;

    public connect() throws SQLException {
        makeConnection();
    }

    public void makeConnection() throws SQLException {

        System.out.println("Connecting to database...");

        if (conn == null) {
            new Driver();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/",
                    "root",
                    "");
        }
        this.conn = conn;
    }

    public void createDB(String db) throws SQLException {

        Statement stmt = conn.createStatement();
        String sql = "CREATE DATABASE IF NOT EXISTS " + db;
        stmt.executeUpdate(sql);

        System.out.println("Database created successfully...");
        this.db = db;

    }

    public Connection getupdatedConn() throws SQLException {
        new Driver();
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/" + this.db,
                "root",
                "");
        return conn;

    }

}
