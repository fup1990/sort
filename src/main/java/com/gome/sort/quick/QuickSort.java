package com.gome.sort.quick;

public class QuickSort {

    public void queckSort(int[] array) {
        int median = getMedian(array[0], array[array.length / 2], array[array.length - 1]);
    }

    /**
     * 首、中、尾三数取中值 min(max(a, b), c)
     * @param first
     * @param mid
     * @param last
     * @return
     */
    private int getMedian(int first, int mid, int last) {
        if (first > mid) {
            if (first > last) {
                if (mid > last) {
                    return mid;
                } else {
                    return last;
                }
            } else {
                return first;
            }
        } else {
            if (first > last) {
                return first;
            } else {
                if (mid > last) {
                    return last;
                } else {
                    return mid;
                }
            }
        }
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int median = sort.getMedian(2, 23, 9);
        System.out.println(median);
    }

}
