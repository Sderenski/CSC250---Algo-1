package sorting.library.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//import sorting.library.Sorter;
import sorting.library.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IterativeTester {
	 protected Integer[] hunRand = new Integer[100];
     protected Integer[] hunDesc = new Integer[100];
     protected Integer[] hunAsc = new Integer[100];
     protected String expected;

     public IterativeTester()
     {
         Random rand = new Random(12271978);
         for(int i = 0; i < hunRand.length; i++)
         {
             hunRand[i] = rand.nextInt(100001);
         }

         //ten = mil.Take(10).ToArray();
         hunDesc = CloneRand();
         Arrays.sort(hunDesc, Collections.reverseOrder());
         
         hunAsc = CloneRand();
         Arrays.sort(hunAsc);
         
         expected = ArrayToString(hunAsc);
     }

     protected Integer[] CloneRand()
     {
         return hunRand.clone();
     }

     protected Integer[] CloneDesc()
     {
         return hunDesc.clone();
     }

     protected Integer[] CloneAsc()
     {
         return hunAsc.clone();
     }
     
     public String ArrayToString(Integer[] a)
     {
         StringBuilder sb = new StringBuilder();

         if (a.length > 0)
         {
             sb.append(a[0]);
             for (int i = 1; i < a.length; i++)
             {
                 sb.append(", ");
                 sb.append(a[i]);
             }

         }

         return sb.toString();
     }
     
     public String ArrayToString(Comparable[] a)
     {
         StringBuilder sb = new StringBuilder();

         if (a.length > 0)
         {
             sb.append(a[0]);
             for (int i = 1; i < a.length; i++)
             {
                 sb.append(", ");
                 sb.append(a[i]);
             }

         }

         return sb.toString();
     }

     @Test
     public void BubbleSortOnRandomArrayOf100()
     {
         Integer[] arr = CloneRand();
         Sorter.bubbleSort(arr);
         String actual = ArrayToString(arr);

         assertEquals(expected, actual);
     }

     @Test
     public void BubbleSortOnAscendingArrayOf100()
     {
         Integer[] arr = CloneAsc();
         Sorter.bubbleSort(arr);
         String actual = ArrayToString(arr);

         assertEquals(expected, actual);
     }

     @Test
     public void BubbleSortOnDescendingArrayOf100()
     {
         Integer[] arr = CloneDesc();
         Sorter.bubbleSort(arr);
         String actual = ArrayToString(arr);

         assertEquals(expected, actual);
     }

     @Test
     public void InsertionSortOnRandomArrayOf100()
     {
         Integer[] arr = CloneRand();
         Sorter.insertionSort(arr);
         String actual = ArrayToString(arr);

         assertEquals(expected, actual);
     }

     @Test
     public void InsertionSortOnAscendingArrayOf100()
     {
         Integer[] arr = CloneAsc();
         Sorter.insertionSort(arr);
         String actual = ArrayToString(arr);

         assertEquals(expected, actual);
     }

     @Test
     public void InsertionSortOnDescendingArrayOf100()
     {
         Integer[] arr = CloneDesc();
         Sorter.insertionSort(arr);
         String actual = ArrayToString(arr);

         assertEquals(expected, actual);
     }

     @Test
     public void SelectionSortOnRandomArrayOf100()
     {
         Integer[] arr = CloneRand();
         Sorter.selectionSort(arr);
         String actual = ArrayToString(arr);

         assertEquals(expected, actual);
     }

     @Test
     public void SelectionSortOnAscendingArrayOf100()
     {
         Integer[] arr = CloneAsc();
         Sorter.selectionSort(arr);
         String actual = ArrayToString(arr);

         assertEquals(expected, actual);
     }

     @Test
     public void SelectionSortOnDescendingArrayOf100()
     {
         Integer[] arr = CloneDesc();
         Sorter.selectionSort(arr);
         String actual = ArrayToString(arr);

         assertEquals(expected, actual);
     }

    @Test
    public void MergeSortOnRandomArrayOf100()
    {
        Integer[] arr = CloneRand();
        Sorter.mergeSort(arr);
        String actual = ArrayToString(arr);

        assertEquals(expected, actual);
    }

    @Test
    public void MergeSortOnAscendingArrayOf100()
    {
        Integer[] arr = CloneAsc();
        Sorter.mergeSort(arr);
        String actual = ArrayToString(arr);

        assertEquals(expected, actual);
    }

    @Test
    public void MergeSortOnDescendingArrayOf100()
    {
        Integer[] arr = CloneDesc();
        Sorter.mergeSort(arr);
        String actual = ArrayToString(arr);

        assertEquals(expected, actual);
    }

    @Test
    public void QuickSortOnRandomArrayOf100()
    {
        Integer[] arr = CloneRand();
        Sorter.quickSort(arr);
        String actual = ArrayToString(arr);

        assertEquals(expected, actual);
    }

    @Test
    public void QuickSortOnAscendingArrayOf100()
    {
        Integer[] arr = CloneAsc();
        Sorter.quickSort(arr);
        String actual = ArrayToString(arr);

        assertEquals(expected, actual);
    }

    @Test
    public void QuickSortOnDescendingArrayOf100()
    {
        Integer[] arr = CloneDesc();
        Sorter.quickSort(arr);
        String actual = ArrayToString(arr);

        assertEquals(expected, actual);
    }

  }