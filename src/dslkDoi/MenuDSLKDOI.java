package dslkDoi;

import java.util.Scanner;


public class MenuDSLKDOI {
    public  void showMenu() {
        LinkList obj = new LinkList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║         DANH SÁCH LIÊN KẾT ĐÔI           ║");
            System.out.println("╠══════════════════════════════════════════╣");
            System.out.println("║  1. Ghi file                             ║");
            System.out.println("║  2. Đọc file                             ║");
            System.out.println("║  3. Nhập sinh viên                       ║");
            System.out.println("║  4. Xóa sinh viên theo mã                ║");
            System.out.println("║  5. Kết quả xếp loại                     ║");
            System.out.println("║  6. Thống kê xếp loại                    ║");
            System.out.println("║  7. In danh sách                         ║");
            System.out.println("║  0. Thoát                                ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    obj.ghifile();
                    System.out.println("Đã ghi file.");
                    break;
                case 2:
                    obj.docfile();
                    System.out.println("Đã đọc file.");
                    break;
                case 3:
                    obj.creatList();
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    String maSV = scanner.nextLine();
                    obj.delete(maSV);
                    System.out.println("Đã xóa sinh viên có mã: " + maSV);
                    break;
                case 5:
                    obj.kQXL();
                    System.out.println("Đã xử lý kết quả.");
                    break;
                case 6:
                    obj.thongKeXepLoai();
                    System.out.println("Đã thống kê xếp loại.");
                    break;
                case 7:
                    obj.printList();
                    System.out.println("Danh sách sinh viên:");
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);

//        scanner.close();
    }
}
