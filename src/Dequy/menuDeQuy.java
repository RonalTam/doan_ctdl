package Dequy;

import java.util.Scanner;

public class menuDeQuy {

    Scanner sc = new Scanner(System.in);
    baiKhuDeQuy khuDQ = new baiKhuDeQuy();
    cacBaiDeQuy deQuy = new cacBaiDeQuy();

    public void menuDQ() {
        int c1;
        do {
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("║               MENU ĐỆ QUY                 ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║ 1. Đệ quy giai thừa                       ║");
            System.out.println("║ 2. Đệ quy Fibonacci                       ║");
            System.out.println("║ 3. Chuyển nhị phân                        ║");
            System.out.println("║ 4. Tính tổng từ 1 - n                     ║");
            System.out.println("║ 5. Tính UCLN của hai số                   ║");
            System.out.println("║ 6. Tính lũy thừa                          ║");
            System.out.println("║ 7. Tính tổng các lũy thừa từ 1^1 - n^n    ║");
            System.out.println("║ 8. Tháp Hà Nội                            ║");
            System.out.println("║ 0. Thoát                                  ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Mời bạn chọn: ");
            c1 = sc.nextInt();

            switch (c1) {
                case 1: {
                    System.out.print("Nhập số để tính giai thừa: ");
                    int n = sc.nextInt();
                    System.out.println("Giai thừa của " + n + " là: " + deQuy.gthua(n));
                    break;
                }
                case 2: {
                    System.out.print("Nhập số thứ tự trong dãy Fibonacci: ");
                    int n = sc.nextInt();
                    System.out.println("Số hạng thứ " + n + " trong dãy Fibonacci là: " + deQuy.f(n));
                    break;
                }
                case 3: {
                    System.out.print("Nhập số để chuyển từ hệ 10 sang hệ 2: ");
                    int n = sc.nextInt();
                    System.out.print("Hệ 2 của số " + n + " là: ");
                    deQuy.chuyenNP(n);
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.print("Nhập n: ");
                    int n = sc.nextInt();
                    System.out.println("Tổng từ 1 đến " + n + " là: " + deQuy.tong(n));
                    break;
                }
                case 5: {
                    System.out.print("Nhập số a: ");
                    int a = sc.nextInt();
                    System.out.print("Nhập số b: ");
                    int b = sc.nextInt();
                    System.out.println("USCLN của " + a + " và " + b + " là: " + deQuy.us(a, b));
                    break;
                }
                case 6: {
                    System.out.print("Nhập x: ");
                    int x = sc.nextInt();
                    System.out.print("Nhập n: ");
                    int n = sc.nextInt();
                    System.out.println(x + "^" + n + " là: " + deQuy.luyThua(x, n));
                    break;
                }
                case 7: {
                    System.out.print("Nhập n: ");
                    int n = sc.nextInt();
                    System.out.println("Tổng các lũy thừa từ 1^1 đến " + n + '^' + n + " là: " + deQuy.tongLthua(n));
                    break;
                }
                case 8: {
                    System.out.print("Nhập số dĩa của tháp: ");
                    int n = sc.nextInt();
                    deQuy.solveHanoi(n, 'A', 'B', 'C');
                    break;
                }
                case 0: {
                    System.out.println("Thoát menu Đệ quy.");
                    break;
                }
                default:
                    System.out.println("Vui lòng chọn lại.");
            }
        } while (c1 != 0);
    }

    public void menuKhuDQ() {
        int c2;
        do {
            System.out.println("╔═══════════════════════════════════════════╗");
            System.out.println("║            MENU KHỬ ĐỆ QUY                ║");
            System.out.println("╠═══════════════════════════════════════════╣");
            System.out.println("║ 1. Khử đệ quy Giai thừa                   ║");
            System.out.println("║ 2. Khử đệ quy Lũy thừa                    ║");
            System.out.println("║ 3. Khử đệ quy Chuyển nhị phân             ║");
            System.out.println("║ 4. Khử đệ quy Dãy Fibonacci               ║");
            System.out.println("║ 0. Thoát                                  ║");
            System.out.println("╚═══════════════════════════════════════════╝");
            System.out.print("Mời bạn chọn: ");
            c2 = sc.nextInt();

            switch (c2) {
                case 1: {
                    System.out.print("Nhập số để tính giai thừa: ");
                    int n = sc.nextInt();
                    System.out.println("Giai thừa của " + n + " là: " + khuDQ.giaiThua(n));
                    break;
                }
                case 2: {
                    System.out.println("Nhập số để tính lũy thừa");
                    System.out.print("Nhập x: ");
                    double x = sc.nextDouble();
                    System.out.print("Nhập n: ");
                    int n = sc.nextInt();
                    System.out.println("Lũy thừa của " + x + "^" + n + " là: " + khuDQ.luyThua(x, n));
                    break;
                }
                case 3: {
                    System.out.print("Nhập số cần chuyển nhị phân: ");
                    int n = sc.nextInt();
                    System.out.println("Nhị phân của " + n + " là " + khuDQ.nhiPhan(n));
                    break;
                }
                case 4: {
                    System.out.print("Nhập số thứ tự trong dãy Fibonacci: ");
                    int n = sc.nextInt();
                    System.out.println("Số hạng thứ " + n + " trong dãy Fibonacci là: " + khuDQ.fibonacci(n));
                    break;
                }
                case 0: {
                    System.out.println("Thoát menu Khử đệ quy.");
                    break;
                }
                default:
                    System.out.println("Vui lòng chọn lại.");
            }
        } while (c2 != 0);
    }
}
