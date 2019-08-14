package com.lhfeiyu.tech.structure.sort;


import java.util.Arrays;

public class AllSort {

    public static void main(String[] args) {
        int[] data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        //babelSort(data);
        //insertSort(data);
    }


    /**
     * 直接插入排序的基本思想是：
     * 将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过为止。
     * @param data
     */
    public static void insertSort(int[] data) {



    }


















    /*public static void babelSort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            System.out.println("-------------------------");
            for (int j = 0; j < i; j++) {
                System.out.println("sort:" + data[j] + " - " + data[j + 1]);
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(data));

    }

    public static void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            System.out.println("-------------------------");
            for (int j = i; j > 0; j--) {
                System.out.println("sort:" + data[j] + " - " + data[j - 1]);
                if (data[j] < data[j - 1]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }else{
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(data));

    }*/


}

