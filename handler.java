package mainten;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aly
 */
public class handler extends connect {

    private connect connn;
    private String tablename;

    public handler(connect c) throws SQLException, NoSuchFieldException {
        this.connn = c;

    }

    public void createTable(String tablename) throws SQLException {

        Statement statement = connn.getupdatedConn().createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS " + tablename
                + "(id INTEGER not NULL, "
                + " name VARCHAR(255), "
                + " pass VARCHAR(255), "
                + " PRIMARY KEY ( id ))";

        statement.executeUpdate(sql);

        this.tablename = tablename;

    }

    public void insertUser(User usr) throws SQLException {
        String name = usr.getName();
        String pass = usr.getPass();
        int ID = usr.getID();

        String insertTableSQL = "INSERT INTO " + tablename
                + "(id, name, pass) VALUES"
                + "(?,?,?)";
        PreparedStatement preparedStatement = connn.getupdatedConn().prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, ID);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, pass);
        
        preparedStatement.executeUpdate();

    }

    public List getAllUsers() throws SQLException {
        List<String> users = new ArrayList<>();

        String sql = "SELECT name FROM Users";
        try (PreparedStatement stmt = connn.getupdatedConn().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(rs.getString("name"));
            }
        }

        return users;
    }

    public List findbyID(int ID) throws SQLException {
        List<String> users = new ArrayList<>();

        String sql = "SELECT name FROM Users WHERE id = ?";
        PreparedStatement stmt = connn.getupdatedConn().prepareStatement(sql);
        stmt.setInt(1, ID);
        ResultSet rs = stmt.executeQuery();
        System.out.println("Printing User with ID= " + ID + ".. ");

        while (rs.next()) {
            users.add(rs.getString("name"));
        }

        return users;

    }
}
