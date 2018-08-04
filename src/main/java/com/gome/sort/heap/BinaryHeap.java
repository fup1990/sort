package com.gome.sort.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fupeng on 2018/8/4.
 */
public class BinaryHeap<T extends Comparable> {

    private List<T> list = new ArrayList<T>();

    public void insert(T t) {
        // 添加到数组末尾
        list.add(t);
        // 上滤
        for (int i = list.size(); i > 0; i /= 2) {
            // 获取父节点
            int pi = (i / 2) - 1 < 0 ? 0 : (i / 2) - 1;
            T p = list.get(pi);
            // 比较
            if (p.compareTo(t) <= 0) {
                break;
            }
            // 与父节点位置交换
            list.set(pi, t);
            list.set(i - 1, p);
        }
    }

    public T delete() {
        // 删除根节点
        T del = list.get(0);
        // 将最后一个节点设置为根节点
        T last = list.remove(list.size() - 1);
        if (list.size() != 0) {
            // 下滤
            int i = 0;
            list.set(i, last);
            while (i < list.size()) {
                int min = getMinChildIndex(i);
                T t = list.get(min);
                if (i != min && last.compareTo(t) > 0) {
                    list.set(i, t);
                    list.set(min, last);
                    i = min;
                } else {
                    break;
                }
            }
        }
        return del;
    }

    /**
     * 根据父节点索引，获取其最小子节点的索引，若没有子节点，则返回父节点索引
     * @param index
     * @return
     */
    private int getMinChildIndex(int index) {
        int left = (index + 1) * 2 - 1;
        int right = (index + 1) * 2;
        if (left < list.size() && right < list.size()) {
            if (list.get(left).compareTo(list.get(right)) > 0) {
                return right;
            } else {
                return left;
            }
        } else {
            return index;
        }
    }

    public List<T> getList() {
        return list;
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> bh = new BinaryHeap<Integer>();
        int[] array = {3,9,20,5,1,87,46,17,4};
        for (int i : array) {
            bh.insert(i);
        }
        List<Integer> list = bh.getList();
        for (int i : list) {
            System.out.println(i);
        }
        System.out.println("========================");
        int size = bh.size();
        for (int i = 0; i < size; i++) {
            Integer delete = bh.delete();
            System.out.println(delete);
        }
    }

}
