package Dequy;

public class baiKhuDeQuy {

    public int giaiThua(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // cau 2
    public double luyThua(double x, int n) {
        if (n < 0) {
            System.out.println("Số mũ không được âm");
            return -1;
        }

        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    // cau 3
    public String nhiPhan(int n) {
        String nhiphan = "";

        while (n > 0) {
            nhiphan = (n % 2) + nhiphan;
            n = n / 2;
        }

        if (nhiphan.equals("")) {
            nhiphan = "0";
        }

        return nhiphan;
    }

    // cau 4
    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;
        int b = 1;
        int fib = 1;

        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }



}
