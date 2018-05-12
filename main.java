package mainten;

import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aly
 */
public class main {

    public static void main(String args[]) throws SQLException, NoSuchFieldException {
        try {

            //establish database connection
            connect c = new connect();

            //create database connection
            c.makeConnection();
            c.createDB("PROJECT_DB");

            System.out.println("Connection established");

            //create users
            User u1 = new User("Ahmed", "testpass1", 0);
            User u2 = new User("Ali", "testpass2", 1);
            User u3 = new User("Mohamed", "testpass3", 2);

            handler h = new handler(c);
            h.createTable("Users");

            //insert users
            h.insertUser(u1);
            h.insertUser(u2);
            h.insertUser(u3);
            
            
            //get all users
            List<String> all_users = h.getAllUsers();
            System.out.println("Printing All Users .. ");
            for (String item : all_users) {
                System.out.println(item);
            }

            //find user by iD
            List<String> selected_users = h.findbyID(0);

            for (String item : selected_users) {
                System.out.println(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Connection error");
        }
    }
}
