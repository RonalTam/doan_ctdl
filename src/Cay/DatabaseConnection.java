package Cay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ctdl"; // Thay đổi URL theo cơ sở dữ liệu của bạn
    private static String USER;
    private static String PASSWORD;

    public static Connection getConnection() throws SQLException {
        Scanner sc = new Scanner(System.in);
        if (URL.length() > 0) {
            System.out.println("Da ket noi toi csdl: " + URL);
        }
        System.out.print("Nhap ten user: ");
        USER = sc.nextLine();
        System.out.print("Nhap password: ");
        PASSWORD = sc.nextLine();
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
