package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Quản lý sản phẩm"; 
        String user = "TuyenGT"; // Tên người dùng
        String password = ""; // Mật khẩu 

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");
            // Thực hiện các truy vấn SQL tại đây
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}