package com.gome.sort.insert;

/**
 * Created by fupeng on 2018/8/4.
 */
public class InsertSort {

    private static int[] array = {3,9,20,5,1,87,46,17,4};

    public static void main(String[] args) {
        insertSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 插入排序
     * @param array
     * @return
     */
    private static int[] insertSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
