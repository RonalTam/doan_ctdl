package dslkDon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ctdl"; // Thay đổi URL theo cơ sở dữ liệu của bạn
    private static String USER;
    private static String PASSWORD;

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        Scanner sc = new Scanner(System.in);

        while (conn == null) {
            try {
                if (URL.length() > 0) {
                    System.out.println("Đã kết nối tới CSDL: " + URL);
                }
                System.out.print("Nhập tên user: ");
                USER = sc.nextLine();
                System.out.print("Nhập password: ");
                PASSWORD = sc.nextLine();

                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Kết nối thành công!");

            } catch (SQLException e) {
                System.err.println("Không thể kết nối tới cơ sở dữ liệu. Vui lòng kiểm tra lại.");
            }
        }

        return conn;
    }
}
