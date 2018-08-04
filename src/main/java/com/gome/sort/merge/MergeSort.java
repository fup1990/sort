package com.gome.sort.merge;

/**
 * Created by fupeng on 2018/8/4.
 */
public class MergeSort {

    public int[] mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int center = (right - left) / 2;
            int[] l = mergeSort(array, left, center);
            int[] r =mergeSort(array, center + 1, right);
            return merge(l, r);
        }
        return array;
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int li = 0;
        int ri = 0;
        for (int i = 0; i < left.length + right.length; i++) {
            int l = left[li];
            int r = right[ri];
            if (l < r) {
                result[i] = l;
                li++;
            } else {
                result[i] = r;
                ri++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {3,9,20,5,1,87,46,17,4};
        MergeSort sort = new MergeSort();
        sort.mergeSort(array, 0, array.length - 1);
    }

}
