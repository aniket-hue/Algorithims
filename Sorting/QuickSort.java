package Sorting;
/**
 * This implementation is not the best one, but it is to easy to understand for first time reader.
 * This code is accepted on an online judge.
 * It is recommended that you go through the theory before reading this code.
 * QuickSort is divide and conquer algorithm.
 * 
 * Pivot divides the array such that the left of pivot there are elements smaller to it 
 * and right of it has greater elements.
 * -------------------------------
 * | pivot > | pivot   | > pivot  |
 * -------------------------------
 */

import java.util.Scanner;

public class Quicksort {
    static int partition(int[] a, int start, int end) {

        int i = start + 1;
        int j = end;
        int piv = a[start];

        while (i <= j) {
            //Finding the first greater element from pivot
            while (i <= end && piv > a[i])
                i++;
            //Finding the first smallest element
            while (j >= start + 1 && piv <= a[j])
                j--;
            //Swapping the greatest and smallest element.
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        
        //Swapping the pivot and jth index element.
        int temp = a[start];
        a[start] = a[j];
        a[j] = temp;
        return j;

    }
    //Sort method
    
    static void sort(int[] a, int start, int end) {
        if (start < end) {
            int pivpos = partition(a, start, end);

            sort(a, start, pivpos - 1);
            sort(a, pivpos + 1, end);
        }
    }

    static void display(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    //Main method 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sort(a, 0, a.length - 1);
        display(a);

    }
}
