package com.lhfeiyu.tech.structure.sort;


import java.util.Arrays;

/**
 * https://itimetraveler.github.io/2017/07/18/%E5%85%AB%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%E4%B8%8Ejava%E5%AE%9E%E7%8E%B0/?utm_source=juhe&utm_source=juhe#%E6%80%BB%E7%BB%93
 */
public class AllSortDemo {

    public static void main(String[] args) {
        int[] data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        babelSort(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        insertSort(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        insertSort2(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        shellSort(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        //selecttionSort(data);
    }

    public static void babelSort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = data[j];
                int b = data[j + 1];
                if (a > b) {
                    data[j] = b;
                    data[j + 1] = a;
                }
            }
        }
        System.out.println(Arrays.toString(data));

    }

    public static void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            for (int j = i; j > 0; j--) {
                if (temp < data[j - 1]) {
                    int tt = data[j - 1];
                    data[j - 1] = temp;
                    data[j] = tt;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    public static void insertSort2(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && temp < data[j - 1]) {
                    data[j] = data[j - 1];
                } else {
                    data[j] = temp;
                    break;

                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    public static void shellSort(int[] data) {
        int gap = data.length / 2;
        for (; gap > 0; gap /= 2) {
            for (int i = 0; (i + gap) < data.length; i++) {
                for (int j = 0; (j + gap) < data.length; j = j + gap) {
                    if (data[j] > data[j + gap]) {
                        int temp = data[j];
                        data[j] = data[j + gap];
                        data[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
            }
        }
        System.out.println(Arrays.toString(data));

    }

    //TODO 8大排序

}

