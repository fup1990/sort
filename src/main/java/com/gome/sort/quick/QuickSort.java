package com.gome.sort.quick;

public class QuickSort {

    public void queckSort(int[] array, int left, int right) {
        if (left < right) {
            int median = getMedian(array[left], array[(left + right) / 2], array[right]);
            // 将中数交换到数组的最后
            if (median == array[left]) {
                array[left] = array[right];
                array[right] = median;
            } else if (median == array[(left + right) / 2]) {
                array[(left + right) / 2] = array[right];
                array[right] = median;
            }
            // 比较
            int i = left;
            int j = right - 1;
            while (true) {
                while (array[i] < median) {
                    i++;
                }
                while (array[j] > median) {
                    j--;
                }
                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else {
                    // 枢纽元与i位置的元素交换
                    array[right] = array[i];
                    array[i] = median;
                    break;
                }
            }
            // 递归
            queckSort(array, left, i - 1);
            queckSort(array, i + 1, right);
        }
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
        int[] array = {3,9,20,5,1,87,46,17,4};
        QuickSort sort = new QuickSort();
        sort.queckSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

}
