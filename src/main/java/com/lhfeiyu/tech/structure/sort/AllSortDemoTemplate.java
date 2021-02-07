package com.lhfeiyu.tech.structure.sort;


import java.util.Arrays;
import java.util.Stack;

/**
 * https://itimetraveler.github.io/2017/07/18/%E5%85%AB%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%E4%B8%8Ejava%E5%AE%9E%E7%8E%B0/?utm_source=juhe&utm_source=juhe#%E6%80%BB%E7%BB%93
 * O(1)  < O(lgn)  <  O(n) <  O(nlgn)  < O(n2)< O(n3)<O(2n)  < O(n!) < O(nn)
 * 直接插入排序（Insertion Sort）
 * 希尔排序（Shell Sort）
 * 冒泡排序（Bubble Sort）
 * 快速排序（Quick Sort）
 * 简单选择排序（Selection Sort）
 * 堆排序（Heap Sort）
 * 归并排序（Merging Sort）
 * 基数排序（Radix Sort）
 */
public class AllSortDemoTemplate {

    public static void main(String[] args) {
        int[] data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        //insertSort11(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        //insertSort12(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        //shellSort(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        //babelSort(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        //quickSort(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        quickSort2(data);
        data = new int[]{23, 454, 67, 787, 3423, 11, 3, 45, 99, 56, 23456};
        selectionSort(data);
    }

    /**
     * 插入排序
     * XXX 直接插入排序之：每次都对比替换 low
     * <p>
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     *
     * @param data 待排序数组
     */
    public static void insertSort11(int[] data) {
        int times = 0;
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            for (int j = i; j > 0; j--) {
                if (temp < data[j - 1]) {
                    int pre = data[j - 1];
                    data[j] = pre;
                    data[j - 1] = temp;
                    System.out.println("sort-" + (++times) + ":" + Arrays.toString(data));
                } else {
                    break;
                }
            }
        }
        System.out.println("all-" + times + ":" + Arrays.toString(data));
    }

    /**
     * 插入排序
     * XXX 直接插入排序之：先对比移动节点，到最终位置时才把temp节点放到正确位置 good
     * <p>
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     *
     * @param data 待排序数组
     */
    public static void insertSort12(int[] data) {
        int times1 = 0;
        int times2 = 0;
        int times = 0;
        for (int i = 1; i < data.length - 1; i++) {
            int temp = data[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && temp < data[j - 1]) {
                    data[j] = data[j - 1];
                    System.out.println("find-" + (++times1) + ":" + Arrays.toString(data));
                    times++;
                } else {
                    data[j] = temp;
                    System.out.println("sort-" + (++times2) + ":" + Arrays.toString(data));
                    times++;
                    break;
                }
            }
        }
        System.out.println("all-" + times + ":" + Arrays.toString(data));
    }

    public static void shellSort(int[] data) {
        int gap = data.length / 2;
        for (; gap > 0; gap /= 2) {
            for (int i = 0; (i + gap) < data.length; i++) {
                for (int j = i; (j + gap) < data.length; j += gap) {
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

    public static void babelSort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j + 1] < data[j]) {
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(data));

    }

    /*public static void babelSort(int[] data) {
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

    }*/

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
        System.out.println("quickSort:" + Arrays.toString(data));
    }

    public static void quickSort(int[] data, int low, int high) {
        if (data.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int temp = data[left];
        while (left < right) {
            while (left < right && data[right] >= temp) {
                right--;
            }
            data[left] = data[right];
            while (left < right && data[left] <= temp) {
                left++;
            }
            data[right] = data[left];
        }
        data[left] = temp;
        quickSort(data, low, left - 1);
        quickSort(data, left + 1, high);
    }

    public static void quickSort2(int[] data) {
        if (data.length <= 0) {
            return;
        }
        int left = 0;
        int right = data.length - 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);

        while (!stack.empty()) {
            int high = stack.pop();
            int low = stack.pop();
            int index = partition(data, low, high);
            if (index > low) {
                stack.push(low);
                stack.push(index - 1);
            }
            if (index < high && index > 0) {
                stack.push(index + 1);
                stack.push(high);
            }

        }
        System.out.println(Arrays.toString(data));
    }

    public static int partition(int[] data, int low, int high) {
        if (data.length <= 0) {
            return -1;
        }
        if (low >= high) {
            return -1;
        }
        int left = low;
        int right = high;
        int temp = data[left];
        while (left < right) {
            while (left < right && data[right] >= temp) {
                right--;
            }
            data[left] = data[right];
            while (left < right && data[left] <= temp) {
                left++;
            }
            data[right] = data[left];
        }
        data[left] = temp;
        return left;

    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int temp = data[i];
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > temp) {
                    temp = data[j];
                    data[j] = data[data.length - 1 - i];
                }
            }
            data[data.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(data));

    }

    /*public static void selectionSort(int[] data) {
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

    }*/


}

