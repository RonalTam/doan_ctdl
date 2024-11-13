package Main;

import Cay.BinaryTreeMenu;
import Dequy.menuDeQuy;
import dslkDon.MenuDSLKDon;
import sapxep.MenuSapXep;

import java.util.Scanner;

public class menu {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int c1;

        do {
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("║              CHƯƠNG TRÌNH QUẢN LÝ         ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║ 1. Đệ quy và khử đệ quy                   ║");
            System.out.println("║ 2. Các thuật toán sắp xếp                 ║");
            System.out.println("║ 3. Danh sách liên kết đơn                 ║");
            System.out.println("║ 4. Quản lí với cấu trúc cây               ║");
            System.out.println("║ 0. Thoát                                  ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Mời bạn chọn: ");
            c1 = sc.nextInt();
            switch (c1) {
                case 1:{
                    menuDeQuy();
                    break;
                }
                case 2: {
                    menuSort();
                    break;
                }
                case 3: {
                    menuLKDON();
                    break;
                }
                case 4: {
                    menuCay();
                    break;
                }
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Vui lòng chọn lại.");
            }
        } while (c1 != 0);
    }

    public static void menuDeQuy() {
        menuDeQuy deQuy = new menuDeQuy();
        int tam;
        do {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║        Lựa chọn thao tác         ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. Làm việc với Đệ quy          ║");
            System.out.println("║  2. Làm việc với khử Đệ quy      ║");
            System.out.println("║  0. Thoát                        ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Mời bạn chọn: ");
            tam = sc.nextInt();
            switch (tam) {
                case 1:
                    deQuy.menuDQ();
                    break;
                case 2:
                    deQuy.menuKhuDQ();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Vui lòng chọn lại.");
                    break;
            }
        } while (tam != 0);
    }

    public static void menuLKDON(){
        MenuDSLKDon lKDON = new MenuDSLKDon();
        lKDON.showMenu();
    }

    public static void  menuCay(){
        BinaryTreeMenu cay = new BinaryTreeMenu();
        cay.showMenu();
    }

    public static void menuSort() {
        MenuSapXep sapXep = new MenuSapXep();
        sapXep.showMenu();
    }

}
