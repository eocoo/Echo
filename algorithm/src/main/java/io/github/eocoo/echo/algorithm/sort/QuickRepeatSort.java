package io.github.eocoo.echo.algorithm.sort;

import java.util.Comparator;

/**
 *
 * 快速排序，重复场景改进版
 *
 * @author shanhm1991@163.com
 *
 */
public class QuickRepeatSort extends Sort {

    @Override
    @SuppressWarnings("all")
    protected void sort(Object[] array, Comparator comp) {
        recursion_partition(array, 0, array.length - 1, comp);
    }

    @SuppressWarnings("all")
    private void recursion_partition(Object[] array, int low, int high, Comparator comp) {
        if (high <= low) {
            return;
        }

        int lt = low, i = low + 1, gt = high;
        while (i <= gt) {
            int cmp = comp(array, i, lt, comp);
            if (cmp < 0) {
                swap(array, lt++, i++);
            } else if (cmp > 0) {
                swap(array, i, gt--);
            } else {
                i++;
            }
        }
        recursion_partition(array, low, lt - 1, comp);
        recursion_partition(array, gt + 1, high, comp);
    }
}
