package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private static String URL = "jdbc:mysql://localhost:3306/quan_ly_san_pham";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return con;
    }
}