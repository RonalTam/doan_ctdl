package sapxep;

public class Insertionsort {

    void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử lớn hơn key đến vị trí tiếp theo
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void iSort() {
        int arr[] = {12, 11, 13, 5, 6, 3, 18, 9};
        System.out.println("Mảng ban đầu:");
        printArray(arr);

        Insertionsort ob = new Insertionsort();
        ob.insertionSort(arr);

        System.out.println("Mảng sau khi sắp xếp bằng Insertion Sort:");
        printArray(arr);
    }
}
