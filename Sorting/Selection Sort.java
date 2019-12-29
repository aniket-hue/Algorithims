package Sorting;

/**
 * Selection sort is an algorithm which find smallest element in a range and place it at its appropriate
 * position in sorted array accordingly.
 *
 * Ex a = <5,4,3,2,1> and j=0
 *     in a[0..4] the smallest element is 1 so put it at first position j=0.
 *     now, a[1..4] the smallest element is 2 so put 2 at second position j=1.
 *     I hope you're getting what I'm trying to say.
 *     For more sorting algorithm refer to the directory.
 *
 *     Time complexities -- O(n^2).
 *
 *     Have fun coding!.
 */


class Selection_sort {

    //Driver method,

    private static void driver(int[] a) {

        //Key is the smallest element in a given range.

        int i, key, j;

        for (i = 0; i < a.length; i++) {

            key = i;

            //Loop to find the smallest element in a range.
            for (j = i + 1; j < a.length; j++)
                if (a[j] < a[key])
                    key = j;

            //Puttig a smallest element at an appropriate position.

            int temp = a[key];
            a[key] = a[i];
            a[i] = temp;

        }
    }

    //Display method.
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
