package dslkDoi;

import java.util.Scanner;

public class LinkList {
    public DoubleLink first, last;
    DoubleLink q = null;
    DoubleLink p = null;

    DoubleLinkDao obj = new DoubleLinkDao();

    public LinkList() {
        first = null;
        last = null;
    }

    public void insert(String maSV, String hoTen, double diem) {
        DoubleLink nut = new DoubleLink(maSV, hoTen, diem);

        if (first == null && last == null) {
            first = nut;
            last = nut;
        } else {
            last.next = nut;
            nut.prev = last;
            last = nut;
        }
    }

    public void creatList() {
        boolean ok = true;
        Scanner sc = new Scanner(System.in);
        while (ok) {
            System.out.print("Nhap ma sinh vien: ");
            String maSV = sc.nextLine();

            if (maSV.isEmpty()) {
                System.out.println("rong");
                ok = false;
                break;
            } else {
                System.out.print("Nhap ho ten: ");
                String hoTen = sc.nextLine();
                System.out.print("Nhap diem: ");
                float diem = sc.nextFloat();
                sc.nextLine();
                insert(maSV, hoTen, diem);
            }
        }
    }

    public void printList() {
        DoubleLink p = first;

        System.out.println("╔══════════════╦══════════════════════════════╦══════════╗");
        System.out.println("║ Mã SV        ║ Họ Tên                       ║ Điểm     ║");
        System.out.println("╠══════════════╬══════════════════════════════╬══════════║");

        while (p != null) {
            System.out.printf("║ %-12s ║ %-28s ║ %-8.2f ║%n", p.getMaSV(), p.getHoTen(), p.getDiem());
            p = p.next;
        }

        System.out.println("╚══════════════╩══════════════════════════════╩══════════╝");
    }

    public void kQXL() {
        DoubleLink p = first;

        System.out.println("╔══════════════╦══════════════════════════════╦══════════╦════════════╦════════════╗");
        System.out.println("║ Mã SV        ║ Họ Tên                       ║ Điểm     ║ Kết Quả    ║ Xếp Loại   ║");
        System.out.println("╠══════════════╬══════════════════════════════╬══════════╬════════════╬════════════╣");

        while (p != null) {
            p.setKq(p.getDiem() >= 5 ? "Đậu" : "Rớt");
            p.setXl(p.getDiem() < 5 ? "Kém" : p.getDiem() >= 5 && p.getDiem() <= 6.5 ? "Trung bình" : p.getDiem() < 8 ? "Khá" : "Giỏi");
            System.out.printf("║ %-12s ║ %-28s ║ %-8.2f ║ %-10s ║ %-10s ║%n",
                    p.getMaSV(), p.getHoTen(), p.getDiem(), p.getKq(), p.getXl());
            p = p.next;
        }

        System.out.println("╚══════════════╩══════════════════════════════╩══════════╩════════════╩════════════╝");
    }

    public DoubleLink search(String maSV) {
        DoubleLink p = first;
        while ((p != null) && !p.getMaSV().equals(maSV)) {
            p = p.next;
        }
        return p;
    }

    public void delete(String maSV) {
        DoubleLink p = search(maSV);
        if (p != null) {
            if ((first == last) && (first == p)) {
                first = null;
                last = null;
            }
            if (p == first) {
                first = first.next;
                first.prev = null;
            } else if (p == last) {
                last = last.prev;
                last.next = null;
            } else {
                DoubleLink u = p.prev, q = p.next;
                if (u != null) u.next = q;
                if (q != null) q.prev = u;
            }
        }
    }

    public void thongKeXepLoai() {
        int soLuongKem = 0;
        int soLuongTB = 0;
        int soLuongKha = 0;
        int soLuongGioi = 0;

        DoubleLink p = first;
        while (p != null) {
            if (p.getDiem() < 5) {
                soLuongKem++;
            } else if (p.getDiem() >= 5.0 && p.getDiem() < 6.5) {
                soLuongTB++;
            } else if (p.getDiem() >= 6.5 && p.getDiem() < 8.0) {
                soLuongKha++;
            } else if (p.getDiem() >= 8.0) {
                soLuongGioi++;
            }
            p = p.next;
        }

        System.out.println("Thống kê xếp loại:");
        System.out.println("Số lượng học sinh Kem: " + soLuongKem);
        System.out.println("Số lượng học sinh Trung bình: " + soLuongTB);
        System.out.println("Số lượng học sinh Khá: " + soLuongKha);
        System.out.println("Số lượng học sinh Giỏi: " + soLuongGioi);
    }

    public void ghifile() {
        insert("1", "Anh A", 9);
        insert("2", "Anh B", 5.5);
        insert("3", "Anh C", 8);
        insert("4", "Anh D", 4);
        insert("5", "Anh E", 2.5);
        obj.ghiFile(first);
    }

    public void docfile() {
        DoubleLink fileList = obj.docFile("D://dslkDoi.txt");

        if (fileList != null) {
            if (first == null) {
                first = fileList;
                last = first;
                while (last.next != null) {
                    last = last.next;
                }
            } else {
                last.next = fileList;
                fileList.prev = last;

                while (last.next != null) {
                    last = last.next;
                }
            }
        } else {
            System.out.println("Không có dữ liệu trong file để đọc.");
        }
    }

}
