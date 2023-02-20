import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    
    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i ++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static boolean isSorted(int[] array) {
        for(int i = 0; i < array.length - 1; i ++) {
            if (array[i] > array[i+1])
            return false;
        }
        return true;
    }

    public static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> a) {
        for (int i = a.size(); i > 1; i --) {
            for (int j = 0; j < i - 1; j ++) {
                if (a.get(j).compareTo(a.get(j+1)) > 0) {
                    E temp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, temp);
                }
            }
        }
    }

    public static void mergeArray(int[] a, int start, int middle, int end) {
        int[] c =new int[end - start];
        int i = start, j = middle, k = 0;

        while (i < middle && j < end) {
            if (a[i] <= a[j]) {
                c[k] = a[i];
                k ++;
                i ++;
            } else {
                c[k] = a[j];
                k ++;
                j ++;
            }
        }

        while (i < middle) {
            c[k] = a[i];
            k ++;
            i ++;
        }

        while (j < end) {
            c[k] = a[j];
            k ++;
            j ++;
        }

        for (i = start; i < end; i ++) {
            a[i] = c[i - start];
        }
    }
    

    public static void mergeSort(int[] a, int start, int end) {
        if (end - start <= 1) {
            return;

        }

        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    

    public static void main(String[] args) throws Exception {
        long start_time, time_spent;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the array length:");
        int arrayLength = scanner.nextInt();
        int[] array = createRandomArray(arrayLength);
        System.out.println("\nBefore sorting, isSorted(array): " + isSorted(array) + "\n");
        start_time = System.currentTimeMillis();
        mergeSort(array);
        time_spent = System.currentTimeMillis() - start_time;
        System.out.println("Merge sort time: " + time_spent + " ms\n");
        start_time = System.currentTimeMillis();
        bubbleSort(array);
        time_spent = System.currentTimeMillis() - start_time;
        System.out.println("Bubble sort time: " + time_spent + " ms\n");
        System.out.println("After sorting, isSorted(array): " + isSorted(array) + "\n");

        scanner.close();
    }
    
}

