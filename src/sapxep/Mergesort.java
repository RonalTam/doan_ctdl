package sapxep;

public class Mergesort {
    void merge(int arr[], int l, int m, int r) {
//        Tim kich thuoc cua 2 mang con de merged
        int n1 = m - l + 1;
        int n2 = r - m;
//        Tao mang tam
        int L[] = new int[n1];
        int R[] = new int[n2];

//        coppy du lieu vao mang tam
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

//        merge cac mang tam lai

//        chi muc ban dau cua 2 mang con
        int i = 0, j = 0;

//        chi muc ban dau cua mang phu duoc hop nhat
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

//        sao chep cac phan tu con lai cua L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

//        sao chep cac phan tu con lai cua R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
//            Tim diem chinh giua
            int m = (l + r) / 2;

//            Ham de quy tiep tuc chia doi
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void mSort() {
        int arr[] = {25, 11, 22, 5, 6, 18, 9, 20, 80, 30};

        System.out.println("Mảng ban đầu:");
        printArray(arr);

        Mergesort ob = new Mergesort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Mảng sau khi sắp xếp bằng Merge Sort:");
        printArray(arr);
    }

}
