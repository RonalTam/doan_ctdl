package dslkDon;

import java.util.Scanner;

public class MenuDSLKDon {
    static Scanner sc = new Scanner(System.in);
    LinkList list = new LinkList();

    public void showMenu() {
        int choice;
        do {
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║           DANH SÁCH LIÊN KẾT ĐƠN         ║");
            System.out.println("╠══════════════════════════════════════════╣");
            System.out.println("║  1.  Nhập dữ liệu từ csdl                ║");
            System.out.println("║  2.  Nhập thêm sinh viên                 ║");
            System.out.println("║  3.  In danh sách                        ║");
            System.out.println("║  4.  In sinh viên có điểm >= 5           ║");
            System.out.println("║  5.  Tìm điểm cao nhất                   ║");
            System.out.println("║  6.  In kết quả đậu/rớt                  ║");
            System.out.println("║  7.  In xếp loại                         ║");
            System.out.println("║  8.  Tìm kiếm sinh viên                  ║");
            System.out.println("║  9.  Xóa sinh viên                       ║");
            System.out.println("║  10. Sắp xếp                             ║");
            System.out.println("║  11. Ghi dữ liệu vào file Excel          ║");
            System.out.println("║  0.  Thoát                               ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    list.readSinhVien();
                    break;
                case 2:
                    list.createList();
                    break;
                case 3:
                    list.printList();
                    break;
                case 4:
                    list.printIf();
                    break;
                case 5:
                    System.out.println("Điểm cao nhất: " + list.max());
                    break;
                case 6:
                    list.printKq();
                    break;
                case 7:
                    list.printXl();
                    break;
                case 8:
                    System.out.print("Nhập mã sinh viên cần tìm: ");
                    String maSV = sc.nextLine();
                    Link found = list.search(maSV);
                    if (found != null) {
                        System.out.println("Sinh viên tìm thấy: Mã SV: " + found.getMaSV() + " - " + found.getHoTen() + " - Điểm: " + found.getDiem());
                    } else {
                        System.out.println("Không tìm thấy sinh viên với mã: " + maSV);
                    }
                    break;
                case 9:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    String maSVToDelete = sc.nextLine();
                    list.delete(maSVToDelete);
                    break;
                case 10:
                    int tam;
                    do {
                        System.out.println("╔══════════════════════════════════╗");
                        System.out.println("║        Lựa chọn thao tác         ║");
                        System.out.println("╠══════════════════════════════════╣");
                        System.out.println("║  1. Sắp xếp theo maSV            ║");
                        System.out.println("║  2. Sắp xếp theo điểm            ║");
                        System.out.println("║  0. Thoát                        ║");
                        System.out.println("╚══════════════════════════════════╝");
                        System.out.print("Mời bạn chọn: ");
                        tam = sc.nextInt();
                        switch (tam) {
                            case 1:
                                list.sortByMaSV();
                                list.printList();
                                break;
                            case 2:
                                list.sortByDiem();
                                list.printList();
                                break;
                            case 0:
                                System.out.println("Thoát chương trình.");
                                break;
                            default:
                                System.out.println("Vui lòng chọn lại.");
                                break;
                        }
                    } while (tam != 0);
                    break;
                case 11:
                    list.excel();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }
}
