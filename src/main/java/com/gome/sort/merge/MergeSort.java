package com.gome.sort.merge;

/**
 * Created by fupeng on 2018/8/4.
 */
public class MergeSort {

    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int center = (right + left) / 2;
            mergeSort(array, left, center);
            mergeSort(array, center + 1, right);
            merge(array, left, center, right);
        }
        return;
    }

    private void merge(int[] array, int left,int center, int right) {
        int[] temp = new int[right - left + 1];
        int li = left;
        int ri = center + 1;
        for (int i = 0; i < temp.length; i++) {
            if (li < center + 1 && ri < right + 1) {
                if (array[li] < array[ri]) {
                    temp[i] = array[li++];
                } else {
                    temp[i] = array[ri++];
                }
            } else {
                if (li > center) {  // 左侧的数组已经没有元素了，则将右侧的剩余元素加入temp
                    temp[i] = array[ri++];
                } else {            // 反之，将左侧的剩余元素加入temp
                    temp[i] = array[li++];
                }
            }
        }
        // 将temp中的元素加入array
        addAll(array, temp, left);
    }

    private void addAll(int[] array, int[] temp, int start) {
        for (int i = 0; i < temp.length; i++) {
            array[start++] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {3,9,20,5,1,87,46,17,4};
        MergeSort sort = new MergeSort();
        sort.mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }


}
