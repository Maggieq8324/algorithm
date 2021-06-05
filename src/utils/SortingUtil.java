package utils;

import selectionSort.SelectionSort;

/**
 * @Description 排序工具类
 * @author coisini
 * @date Jun 4, 2021
 * @Version 1.0
 */
public class SortingUtil {

    private SortingUtil () {}

    /**
     * 验证排序是否正确
     * @param arr
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> boolean isSorted (T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0) {
                return false;
            }
        }

        return true;
    }

    public static <T extends Comparable<T>> void sortTest (String className, T[] arr) {

        long startTime = System.nanoTime();

        if ("SelectionSort".equals(className)) {
            SelectionSort.sort(arr);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 100000000.0;

        if (!SortingUtil.isSorted(arr)) {
            throw new RuntimeException(className + " sort is failed");
        }

        System.out.println(String.format("%s, n = %d : %f s)", className, arr.length, time));



    }

}
