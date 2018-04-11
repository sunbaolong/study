package sort;

import util.StdOut;

/**
 * 选择排序
 */
public class ChooseSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {11, 21, 10, 2, 3, 18, 100, 99, 20, 20, 123, 25};
        ChooseSort chooseSort = new ChooseSort();
        chooseSort.sort(a);
        show(a);
        StdOut.println(isSorted(a));

        String[] s = {"z", "b", "c", "a", "a", "e", "g", "f"};
        chooseSort.sort(s);
        show(s);
        StdOut.println(isSorted(s));
    }
}
