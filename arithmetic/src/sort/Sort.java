package sort;

import util.StdOut;

public abstract class Sort {
    abstract void sort(Comparable[] a);

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {11, 21, 10, 2, 3, 18, 100, 99, 20};
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                exch(a, i - 1, i);
        }
        show(a);
        StdOut.println(isSorted(a) + " ");
    }

}
