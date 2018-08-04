package com.gome.sort.shell;

/**
 * Created by fupeng on 2018/8/4.
 */
public class ShellSort {

    private static int[] array = {3,9,20,5,1,87,46,17,4};

    public static void main(String[] args) {
        shellSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static int[] shellSort(int[] array) {
        for (int i = array.length / 2; i > 0; i /= 2) {     //定义步长
            for (int j = 0; j < array.length - i; j++) {    //从头至尾逐个执行
                for (int k = i; k < array.length; k += i) { //所以相隔k的两个元素比较
                    int temp;
                    if (array[k - i] > array[k]) {
                        temp = array[k - i];
                        array[k - i] = array[k];
                        array[k] = temp;
                    }
                }
            }
        }
        return array;
    }

}
