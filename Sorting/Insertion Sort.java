package Sorting;

/**
 * Insertion sort breaks the array into an partially sorted and unsorted array
 * an element(key) is taken and compared over the array until we find the appropriate position.
 * -------------------------------
 * | <= key  | >key    | key      |
 * -------------------------------
 * <p>
 * Ex- a=<5,4,3,2>
 * iterations--
 * 4 5 3 2
 * 4 3 5 2
 * 3 4 5 2
 * 3 4 2 5
 * 3 2 4 5
 * 2 3 4 5
 * I hope you're getting what I'm trying to say.
 * For more sorting algorithm refer to the directory.
 * <p>
 * Time complexities -- O(n) in best case and O(n^2) for average and worst
 * Have fun coding!.
 */

public class Insertion_sort {
    
    //Driver method
    
    private static void driver(int[] a) {
        int i, j, key;
        
        for (j = 1; j < a.length; j++) {
            
            //key is the element which will compared to other elements.
            
            key = a[j];
            i = j - 1;
            
            while (i >= 0 && a[i] > key) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                i--;
            }
        }
    }
    
    //Display method
    
    private static void display(int[] a) {
        for (int i : a) {
            System.out.println(i);
        }
    }
    //Main method
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        driver(a);
        display(a);
    }
}
