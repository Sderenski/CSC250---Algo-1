package sorting.library;

import java.util.Random;

public class Main {
    public static void main(String args[]){
        Sorter sorter = new Sorter();
        Random rand = new Random();

        Comparable[] arrayTest = new Comparable[100];
        for (int i = 0; i < arrayTest.length; i++){
            arrayTest[i] = rand.nextInt(101);
        }
        System.out.println("Before Sort");
        for (Comparable comparable : arrayTest) {
            System.out.print(comparable + " ");
        }
        System.out.println();

        sorter.quickSort(arrayTest);

//        System.out.println("After Sort");
//        for (Comparable comparable : arrayTest) {
//            System.out.print(comparable + " ");
//        }
        System.out.println();
    }
}
