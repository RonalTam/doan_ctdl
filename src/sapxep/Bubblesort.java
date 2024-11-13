package sapxep;

public class Bubblesort {

    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void bSort() {
        int arr[] = {64, 34, 25, 12, 22, 11, 90, 3, 44, 18, 99};
        System.out.println("Mảng ban đầu:");
        printArray(arr);

        Bubblesort ob = new Bubblesort();
        ob.bubbleSort(arr);

        System.out.println("Mảng sau khi sắp xếp bằng Bubble Sort:");
        printArray(arr);
    }
}