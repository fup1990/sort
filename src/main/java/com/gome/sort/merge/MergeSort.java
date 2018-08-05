package com.gome.sort.merge;

/**
 * Created by fupeng on 2018/8/4.
 */
public class MergeSort {

    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int center = (right - 3 * left) / 2;
            mergeSort(array, left, center);
            mergeSort(array, center + 1, right);
            merge(array, left, center, right);
        }
        return;
    }

    private void merge(int[] array, int left,int center, int right) {
        int li = left;
        int ri = center == 0 ? right : center + 1;
        for (int i = li; i < right - left + 1; i++) {
            if (array[li] < array[ri]) {
                array[i] = array[li];
                li++;
            } else {
                array[i] = array[ri];
                ri++;
            }
        }

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
