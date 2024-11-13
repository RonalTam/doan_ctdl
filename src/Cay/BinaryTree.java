package Cay;

import dslkDon.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BinaryTree {
    public Node root;

    // Constructor khởi tạo cây rỗng
    public BinaryTree() {
        root = null;
    }

    // Phương thức thêm một node mới vào cây
    public Node insertNode(Node root, String maSV, String hoTen, double diem) {
        if (root == null) {
            root = new Node(maSV, hoTen, diem);
            return root;
        }
        if (root.getMaSV().compareTo(maSV) > 0) {
            root.left = insertNode(root.left, maSV, hoTen, diem);
        } else if (root.getMaSV().compareTo(maSV) < 0) {
            root.right = insertNode(root.right, maSV, hoTen, diem);
        }
        return root;
    }

    // Phương thức tạo cây từ nhập liệu của người dùng
    public void create() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập mã SV (hoặc ấn Enter để dừng): ");
            String maSV = sc.nextLine();

            if (maSV.isEmpty()) {
                break;
            }

            System.out.print("Nhập họ tên: ");
            String hoTen = sc.nextLine();

            System.out.print("Nhập điểm: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Điểm không hợp lệ. Vui lòng nhập lại.");
                sc.next();
            }
            double diem = sc.nextDouble();
            sc.nextLine();

            root = insertNode(root, maSV, hoTen, diem);
        }
    }

    // Duyệt cây theo thứ tự trái - gốc - phải
    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);

            System.out.printf("║ %-12s ║ %-28s ║ %-8.2f ║%n",
                    root.getMaSV(), root.getHoTen(), root.getDiem());

            inOrderTraversal(root.right);
        }
    }

    // Phương thức để gọi
    public void printInOrder() {
        if (root != null) {
            System.out.println("╔══════════════╦══════════════════════════════╦══════════╗");
            System.out.println("║ Mã SV        ║ Họ Tên                       ║ Điểm     ║");
            System.out.println("╠══════════════╬══════════════════════════════╬══════════╣");

            inOrderTraversal(root);

            System.out.println("╚══════════════╩══════════════════════════════╩══════════╝");
        } else {
            System.out.println("Cây đang rỗng.");
        }
    }

    // Duyệt cây theo gốc - trái - phải (Pre-order)
    public void preOrderTraversal(Node root) {
        if (root != null) {
            // In thông tin của node hiện tại
            System.out.printf("║ %-12s ║ %-28s ║ %-8.2f ║%n",
                    root.getMaSV(), root.getHoTen(), root.getDiem());

            // Duyệt cây con trái
            preOrderTraversal(root.left);

            // Duyệt cây con phải
            preOrderTraversal(root.right);
        }
    }

    public void printPreOrder() {
        if (root != null) {
            System.out.println("╔══════════════╦══════════════════════════════╦══════════╗");
            System.out.println("║ Mã SV        ║ Họ Tên                       ║ Điểm     ║");
            System.out.println("╠══════════════╬══════════════════════════════╬══════════╣");

            preOrderTraversal(root);

            System.out.println("╚══════════════╩══════════════════════════════╩══════════╝");
        } else {
            System.out.println("Cây đang rỗng.");
        }
    }

    public String minValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.getMaSV();
    }

    public Node delete(Node root, String maSV) {
        if (root == null){
            System.out.println("Không tìm thấy sinh viên có mã: " + maSV);
            return root;
        }

        if (root.getMaSV().compareTo(maSV) > 0) {
            root.left = delete(root.left, maSV);
        } else if (root.getMaSV().compareTo(maSV) < 0) {
            root.right = delete(root.right, maSV);
        } else {
            // Node cần xóa có tối đa một con
            if (root.left == null) {
                System.out.println("Đã xóa sinh viên có mã: " + maSV);
                return root.right;
            }
            if (root.right == null) {
                System.out.println("Đã xóa sinh viên có mã: " + maSV);
                return root.left;
            }

            // Node cần xóa có hai con
            root.setMaSV(minValue(root.right));
            root.right = delete(root.right, root.getMaSV());
            System.out.println("Đã xóa sinh viên có mã: " + maSV);
        }
        return root;
    }

    public void search(Node root, String maSV) {
        Node current = root;
        while (current != null) {
            if (current.getMaSV().compareTo(maSV) > 0) {
                current = current.left;
            } else if (current.getMaSV().compareTo(maSV) < 0) {
                current = current.right;
            } else {
                System.out.println("Sinh viên tìm thấy: " + current.getHoTen() + " | Điểm: " + current.getDiem());
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có mã " + maSV);
    }

    public void readSinhVien() {
        String query = "SELECT * FROM sinhvien"; // Câu lệnh SQL để lấy dữ liệu từ bảng sinhvien

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Đọc dữ liệu từ cơ sở dữ liệu...");

            while (rs.next()) {
                // Lấy dữ liệu từ kết quả truy vấn
                String maSV = rs.getString("MaSV");
                String hoTen = rs.getString("HoTen");
                double diem = rs.getDouble("Diem");

                // Thêm sinh viên vào cây
                root = insertNode(root, maSV, hoTen, diem);
            }

        } catch (SQLException e) {
            System.err.println("Xảy ra lỗi khi đọc dữ liệu: " + e.getMessage());
        }
    }


}
