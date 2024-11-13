package Cay;

import java.util.Scanner;

public class BinaryTreeMenu {
    static Scanner sc = new Scanner(System.in);
    BinaryTree tree = new BinaryTree();

    public void showMenu() {
        int choice;
        do {
            // Hiển thị menu
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                MENU CÂY NHỊ PHÂN               ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║  1. Nhập dữ liệu từ cơ sở dữ liệu              ║");
            System.out.println("║  2. Nhập sinh viên                             ║");
            System.out.println("║  3. In danh sách sinh viên theo thứ tự         ║");
            System.out.println("║  4. Xóa sinh viên theo mã                      ║");
            System.out.println("║  5. Tìm kiếm sinh viên theo mã                 ║");
            System.out.println("║  0. Thoát                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Nhập lựa chọn: ");

            while (!sc.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                sc.next();
                System.out.print("Nhập lựa chọn: ");
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Đang đọc dữ liệu từ cơ sở dữ liệu...");
                    tree.readSinhVien();
                    System.out.println("Dữ liệu đã được thêm vào cây.");
                    break;

                case 2:
                    System.out.print("Nhập mã sinh viên: ");
                    String maSV = sc.nextLine();

                    System.out.print("Nhập họ tên sinh viên: ");
                    String hoTen = sc.nextLine();

                    System.out.print("Nhập điểm: ");
                    double diem;
                    while (true) {
                        if (sc.hasNextDouble()) {
                            diem = sc.nextDouble();
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("Điểm không hợp lệ. Vui lòng nhập lại.");
                            sc.next();
                        }
                    }

                    tree.root = tree.insertNode(tree.root, maSV, hoTen, diem);
                    System.out.println("Đã thêm sinh viên vào cây.");
                    break;

                case 3:
                    int choice1;
                    do {
                        System.out.println("╔═══════════════════════════════════════════════════════════╗");
                        System.out.println("║  1. Duyệt cây theo thứ tự trái-gốc-phải (In-order)        ║");
                        System.out.println("║  2. Duyệt cây theo thứ tự gốc-trái-phải (Pre-order)       ║");
                        System.out.println("║  0. Thoát                                                 ║");
                        System.out.println("╚═══════════════════════════════════════════════════════════╝");
                        System.out.print("Nhập lựa chọn: ");
                        choice1 = sc.nextInt();
                        sc.nextLine();
                        switch (choice1) {
                            case 1:
                                tree.printInOrder();
                                break;
                            case 2:
                                tree.printPreOrder();
                                break;
                            case 0:
                                System.out.println("Thoát.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        }

                    } while (choice1 != 0);
                    break;

                case 4:
                    if (tree.root == null) {
                        System.out.println("Cây đang rỗng. Không có gì để xóa.");
                    } else {
                        System.out.print("Nhập mã sinh viên cần xóa: ");
                        String maSVXoa = sc.nextLine();
                        tree.root = tree.delete(tree.root, maSVXoa);
                    }
                    break;

                case 5:
                    System.out.print("Nhập mã sinh viên cần tìm: ");
                    String maSVTim = sc.nextLine();
                    tree.search(tree.root, maSVTim);
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        } while (choice != 0);
        sc.close();
    }
}
