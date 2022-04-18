package sorting.library;

import java.util.Arrays;

public class Sorter<T extends Comparable<? super T>> {

    // Bubble Sort
    public static void bubbleSort(Comparable[] arr) {
        /*
        Pseudo Code

        for i <- 0 to n - 2 do
            for j <- 0 to n - 2 - i do
                if A[j + 1] < A[j] swap A[j] and A[j + 1]
         */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1].compareTo(arr[j]) == -1) {
                    swap(arr, j + 1, j);
                }
            }
        }

    }

    // Selection Sort
    public static void selectionSort(Comparable[] arr) {
        /*
        Pseudo Code

            for i <- 0 to n - 2 do
                min <- i
                for j <- i + 1 to n - 1 do
                    if A[j] < A[min] min <- j
                swap A[i] and A[min]
         */

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) == -1) {
                    min = j;
                }
            }
            swap(arr, i, min);

        }
    }

    // Insertion Sort
    public static void insertionSort(Comparable[] arr) {
        /*
        Pseudo Code

            for i <- 1 to n - 1 do
                v <- A[i]
                j <- i - 1
                while j >= 0 and A[j] > v do
                    A[j + 1] <- A[j]
                    j <- j - 1
                A[j + 1] <- v
         */

        for (int i = 1; i < arr.length; i++) {
            Comparable v = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(v) == 1) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = v;
        }


    }

    public static void swap(Comparable[] arr, int nextP, int firstP) {
        Comparable temp = arr[nextP];
        arr[nextP] = arr[firstP];
        arr[firstP] = temp;
    }

    // ********* The recursive functions ******

    // Match Sort
    public static void mergeSort(Comparable[] arr){
        /*
            ****** Pseudo Code *******

            if n > 1
                copy A[0..[n/2] - 1] to B[0..[n/2] - 1]
                copy A[[n/2]..n - 1] to C[0..[n/2] - 1]
                mergeSort(B[0..[n/2] - 1])
                mergeSort(C[0..[n/2] - 1])
                merge(B, C, A)
         */
        if (arr.length > 1){
            Comparable[] arrB = Arrays.copyOfRange(arr, 0, (arr.length/2));
            Comparable[] arrC = Arrays.copyOfRange(arr, (arr.length/2), arr.length);
            mergeSort(arrB);
            mergeSort(arrC);
            merge(arrB, arrC, arr);
        }
    }

    // Merge Function
    private static void merge(Comparable[] arrB, Comparable[] arrC, Comparable[] arrA){
        /*
            ***** Pseudo Code ********
            p = arrB.length
            q = arrC.length

            i <- 0;
            j <- 0;
            k <- 0;
            while i < p and j < q do
                if B[i] <= C[j]
                    A[k] <- B[i];
                    i <- i + 1;
                else
                    A[k] <- C[j];
                    j <- j + 1;
                k <- k + 1
            if i = p
                copy C[j..q - 1] to A[k..p + q - 1]
            else
                copy B[i..p - 1] to A[k..p + q - 1]
         */
        int i = 0;
        int j = 0;
        int k = 0;
        int p = arrB.length;
        int q = arrC.length;
        while (i < p && j < q){
            if (arrB[i].compareTo(arrC[j]) <= 0) {
                arrA[k] = arrB[i];
                i += 1;
            } else {
                arrA[k] = arrC[j];
                j += 1;
            }
            k += 1;
        }
        int end = p + q;
        if (i == p){
            copy(arrC, arrA, k, end, j);
        } else {
            copy(arrB, arrA, k, end , i);
        }

    }

    // Copy Function for MergeSort
    /*
    if i = p
        copy C[j..q - 1] to A[k..p + q - 1]
    else
        copy B[i..p - 1] to A[k..p + q - 1]
    */
    private static void copy(Comparable[] arrFrom, Comparable[] arrTo, int k, int end, int zero){
        while (k < end || zero < arrFrom.length){
            arrTo[k] = arrFrom[zero];
            k++;
            zero++;
        }
    }


    // Quick Sort
    // TODO Doesn't Work YET

    public static void quickSort(Comparable[] arr){
    /*
        *** Pseudo Code *****

        if l < r
            s <- Partition(A[l..s - 1]) // s is a split position
            Quicksort(A[l..s - 1])
            Quicksort(A[s + 1..r])
     */
        quickSort(arr, 0, arr.length -1);
        reverseArray(arr);
    }

    public static void quickSort(Comparable[] arr, int low, int hi){
        if (low < hi){
            int s = partition(arr, low, hi);
            // I think this is the issue area
            // TODO don't pass copied arrays, pass the actually array
            quickSort(arr, low, s - 1);
            quickSort(arr, s, hi);
        }

    }



    // Partition Method
    private static int partition(Comparable[] arr, int lo, int hi){
        /*
            ****** Pseudo Code *******

        p <- A[l]
        i <- l; j <- r + 1;
        repeat
            repeat i <- i + 1 until A[i] >= p
            repeat j <- j - 1 until A[j] <= p
            swap(A[i], A[j])
        until i >= j
        swap (A[i], A[j]) // undo last swap when i >= j
        swap (A[l], A[j])
        return j
         */
        Comparable p = arr[hi];
        int i = lo - 1;
        for(int j = lo; j <= hi-1; j++) {
            if (arr[j].compareTo(p) > 0) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, hi);
        return i + 1;
    }

    private static void reverseArray(Comparable[] arr){
        for (int i = 0; i < (arr.length/2); i++) {
            Comparable temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
