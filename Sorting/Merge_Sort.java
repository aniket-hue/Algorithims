package Sorting;
/**
 * The code is Accepted on SPOJ.
 */

import java.util.Scanner;

public class Merge_Sort {
    //Code for partitioning
    static void merge_sort(int[] a, int start, int end) {
        
        if (start < end) {

            int mid = (start + end) / 2;

            merge_sort(a, start, mid);
            merge_sort(a, mid + 1, end);
            merge(a, start, end, mid);

        }

    }

    static void merge(int[] a, int start, int end, int mid) {

        //Pointer for crawling the array
        //left pointer will crawl the left partition
        //right pointer will crawl right partition
        //basicpointer is the pointer to arr
        int leftpoint = start, rightpointer = mid + 1, basicpointer = 0;

        //For storing the partially sorted array
        int[] arr = new int[end - start + 1];

        //Enter the loop if one of the partition exists
        while (leftpoint < mid + 1 || rightpointer < end + 1) {
        
            //if both partition exist
            if (leftpoint < mid + 1 && rightpointer < end + 1) {

                //finding the small value in both partition
                if (a[leftpoint] <= a[rightpointer])
                    arr[basicpointer++] = a[leftpoint++];

                else if (a[leftpoint] > a[rightpointer])
                    arr[basicpointer++] = a[rightpointer++];

            }

            else if (leftpoint < mid + 1)
                arr[basicpointer++] = a[leftpoint++];

            else
                arr[basicpointer++] = a[rightpointer++];
        }

        int k = start;
        //To write new sorted elements in original array
        for (int i = 0; i < arr.length; i++) {
            {
                a[k++] = arr[i];
                //display(a);
            }
            //display(a);
        }
    }

    static void display(int[] a) {

        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s = sc.nextLine();
        String[] ch=s.split(" ");
        
        int[] a = new int[ch.length];
        
        int i=0;
        
        for (String ss: ch)
            a[i++] = Integer.parseInt(ss);
        
        merge_sort(a, 0, a.length - 1);

        display(a);
    }
}
