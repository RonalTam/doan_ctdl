package sapxep;

import java.util.Scanner;

public class MenuSapXep {
    static Scanner sc = new Scanner(System.in);
    Mergesort ms = new Mergesort();
    Quicksort qs = new Quicksort();
    Bubblesort bs = new Bubblesort();
    Insertionsort is = new Insertionsort();

    public void showMenu() {
        int tam;
        do {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║        Lựa chọn thao tác         ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. Quicksort                    ║");
            System.out.println("║  2. Mergesort                    ║");
            System.out.println("║  3. Bubblesort                   ║");
            System.out.println("║  4. Insertionsort                ║");
            System.out.println("║  0. Thoát                        ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Mời bạn chọn: ");
            tam = sc.nextInt();
            switch (tam) {
                case 1:
                    qs.qSort();
                    break;
                case 2:
                    ms.mSort();
                    break;
                case 3:
                    bs.bSort();
                    break;
                case 4:
                    is.iSort();
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
}
