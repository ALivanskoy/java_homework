// Реализовать алгоритм пирамидальной сортировки (HeapSort).
import java.util.Random;

public class Task3 {

    public static void main(String args[]) {
        int arr[] = fillArray(10, 0, 10);

        System.out.println("Исходный массив:");
        printArray(arr);
        System.out.println("Отсортированный массив:");
        sort(arr);
        printArray(arr);
    }

    static int[] fillArray(int value, int min, int max) {
        int[] outputArray = new int[value];
        Random rand = new Random();

        for (int i = 0; i < outputArray.length; i++) {
            outputArray[i] = rand.nextInt(min, max);
        }

        return outputArray;
    }

    public static void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            pile(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            pile(arr, i, 0);
        }
    }

    static void pile(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            pile(arr, n, largest);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}