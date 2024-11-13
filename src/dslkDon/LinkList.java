package dslkDon;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;




public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public void insert(String maSV, String hoTen, double diem) {
        if (search(maSV) != null) {
            System.out.println("Mã sinh viên " + maSV + " đã tồn tại. Vui lòng nhập mã khác.");
            return;
        }

        Link nut = new Link(maSV, hoTen, diem);
        if (first == null) {
            first = nut;
        } else {
            Link p = first;
            while (p.nextLink != null) {
                p = p.nextLink;
            }
            p.nextLink = nut;
        }
        System.out.println("Đã thêm sinh viên: " + maSV + " - " + hoTen + " - " + diem);

    }

    public void createList() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String maSV = "";
            System.out.print("Nhập mã sinh viên: ");
            maSV = sc.nextLine();
            if (maSV.isEmpty()) {
                break;
            } else {
                System.out.print("Họ tên: ");
                String hoTen = sc.nextLine();
                System.out.print("Điểm: ");
                double diem = sc.nextDouble();
                sc.nextLine();
                insert(maSV, hoTen, diem);
            }
        }
    }

    public void printList() {
        Link p = first;

        System.out.println("╔══════════════╦══════════════════════════════╦══════════╗");
        System.out.println("║ Mã SV        ║ Họ Tên                       ║ Điểm     ║");
        System.out.println("╠══════════════╬══════════════════════════════╬══════════╣");

        while (p != null) {
            System.out.printf("║ %-12s ║ %-28s ║ %-8.2f ║%n",
                    p.getMaSV(), p.getHoTen(), p.getDiem());

            p = p.nextLink;
        }

        System.out.println("╚══════════════╩══════════════════════════════╩══════════╝");
    }

    public void printIf() {
        Link p = first;

        System.out.println("╔══════════════╦══════════════════════════════╦══════════╗");
        System.out.println("║ Mã SV        ║ Họ Tên                       ║ Điểm     ║");
        System.out.println("╠══════════════╬══════════════════════════════╬══════════╣");

        while (p != null) {
            if (p.getDiem() >= 5) {
                System.out.printf("║ %-12s ║ %-28s ║ %-8.2f ║%n",
                        p.getMaSV(), p.getHoTen(), p.getDiem());
            }
            p = p.nextLink;
        }

        System.out.println("╚══════════════╩══════════════════════════════╩══════════╝");
    }

    public double max() {
        if (first == null) {
            return -1;
        }

        Link p = first;
        double m = p.getDiem();

        while (p != null) {
            if (m < p.getDiem()) {
                m = p.getDiem();
            }
            p = p.nextLink;
        }

        return m;
    }

    public void printKq() {
        Link p = first;

        System.out.println("╔══════════════╦══════════════════════════════╦══════════╦═══════════╗");
        System.out.println("║ Mã SV        ║ Họ Tên                       ║ Điểm     ║ Kết Quả   ║");
        System.out.println("╠══════════════╬══════════════════════════════╬══════════╬═══════════╣");

        while (p != null) {
            if (p.getDiem() < 5) {
                p.setXl("Rớt");
            } else {
                p.setXl("Đậu");
            }

            System.out.printf("║ %-12s ║ %-28s ║ %-8.2f ║ %-9s ║%n",
                    p.getMaSV(), p.getHoTen(), p.getDiem(), p.getXl());

            p = p.nextLink;
        }

        System.out.println("╚══════════════╩══════════════════════════════╩══════════╩═══════════╝");
    }


    public void printXl() {
        Link p = first;

        System.out.println("╔══════════════╦══════════════════════════════╦══════════╦════════════╦════════════╗");
        System.out.println("║ Mã SV        ║ Họ Tên                       ║ Điểm     ║ Kết Quả    ║ Xếp Loại   ║");
        System.out.println("╠══════════════╬══════════════════════════════╬══════════╬════════════╬════════════╣");

        while (p != null) {
            p.setKq(p.getDiem() < 5 ? "Rớt" : "Đậu");
            p.setXl(p.getDiem() < 5 ? "Kém" : p.getDiem() < 6.5 ? "Trung Bình" : p.getDiem() < 8 ? "Khá" : "Giỏi");
            System.out.printf("║ %-12s ║ %-28s ║ %-8.2f ║ %-10s ║ %-10s ║%n",
                    p.getMaSV(), p.getHoTen(), p.getDiem(), p.getKq(), p.getXl());
            p = p.nextLink;
        }

        System.out.println("╚══════════════╩══════════════════════════════╩══════════╩════════════╩════════════╝");


    }

    public Link search(String maSV) {
        Link p = first;
        while ((p != null) && !p.getMaSV().equals(maSV)) {
            p = p.nextLink;
        }
        return p;
    }

    public void delete(String maSV) {
        Link p = search(maSV);

        if (p != null) {
            if (p == first) {
                first = first.nextLink;
            } else {
                Link u = first;
                while (u != null && u.nextLink != p) {
                    u = u.nextLink;
                }

                if (u != null) {
                    u.nextLink = p.nextLink;
                }
            }
            System.out.println("Đã xóa sinh viên có mã: " + maSV);

        } else {
            System.out.println("Không tìm thấy sinh viên có mã: " + maSV);
        }
    }

    public void sortByDiem() {
        if (first == null || first.nextLink == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Link current = first;
            Link prev = null;

            while (current.nextLink != null) {
                // So sánh điểm của hai nút liên tiếp
                if (current.getDiem() > current.nextLink.getDiem()) {
                    // Hoán đổi dữ liệu giữa current và nextLink
                    String tempMaSV = current.getMaSV();
                    String tempHoTen = current.getHoTen();
                    double tempDiem = current.getDiem();

                    current.setMaSV(current.nextLink.getMaSV());
                    current.setHoTen(current.nextLink.getHoTen());
                    current.setDiem(current.nextLink.getDiem());

                    current.nextLink.setMaSV(tempMaSV);
                    current.nextLink.setHoTen(tempHoTen);
                    current.nextLink.setDiem(tempDiem);

                    swapped = true; // Đã hoán đổi, cần kiểm tra lại
                }
                prev = current;
                current = current.nextLink;
            }
        } while (swapped);
    }

    public void sortByMaSV() {
        if (first == null || first.nextLink == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Link current = first;
            Link prev = null;

            while (current.nextLink != null) {
                // So sánh điểm của hai nút liên tiếp
                if (current.getMaSV().compareTo(current.nextLink.getMaSV()) > 0) {
                    // Hoán đổi dữ liệu giữa current và nextLink
                    String tempMaSV = current.getMaSV();
                    String tempHoTen = current.getHoTen();
                    double tempDiem = current.getDiem();

                    current.setMaSV(current.nextLink.getMaSV());
                    current.setHoTen(current.nextLink.getHoTen());
                    current.setDiem(current.nextLink.getDiem());

                    current.nextLink.setMaSV(tempMaSV);
                    current.nextLink.setHoTen(tempHoTen);
                    current.nextLink.setDiem(tempDiem);

                    swapped = true; // Đã hoán đổi, cần kiểm tra lại
                }
                prev = current;
                current = current.nextLink;
            }
        } while (swapped);
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

                // Thêm sinh viên vào DSLK
                insert(maSV, hoTen, diem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Xay ra loi. Vui long thuc hien lai");
        }
    }

    public void excel() {
        // Tạo workbook và sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Danh sách sinh viên");

        // Tạo tiêu đề cho bảng
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã SV");
        headerRow.createCell(1).setCellValue("Họ Tên");
        headerRow.createCell(2).setCellValue("Điểm");

        // Ghi dữ liệu từ danh sách vào bảng Excel
        int rowNum = 1; // bắt đầu ghi từ dòng thứ 2
        Link p = first;
        while (p != null) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(p.getMaSV());
            row.createCell(1).setCellValue(p.getHoTen());
            row.createCell(2).setCellValue(p.getDiem());
            p = p.nextLink;
        }

        // Ghi file Excel
        try (FileOutputStream fileOut = new FileOutputStream("sinh_vien.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Dữ liệu đã được xuất ra file sinh_vien.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
