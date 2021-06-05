package selectionSort;

import utils.SortingUtil;

/**
 * @Description 选择排序算法
 * @author coisini
 * @date Jun 4, 2021
 * @Version 1.0
 */
public class SelectionSort {

    /**
     * 私有构造函数，该类不被别人创建，直接使用该类的sort函数
     */
    private SelectionSort(){}

    /**
     * 泛型选择排序法
     * 原地排序
     * 于自定义的类，要重写compareTo方法
     * @param arr
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        // arr[0...i) 是有序的; arr[i...n) 是无序的
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i...n) 中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    /**
     * 泛型倒序选择排序
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void reverseSort (T[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[index]) > 0) {
                    index = j;
                }
            }

            swap(arr, i, index);
        }
    }

    /**
     * 交换元素位置
     * @param arr
     * @param i
     * @param j
     */
    private static <T> void swap (T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) throws Exception{
        /**
         * 测试一 正序排序
         */
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        /**
         * 测试二 倒序排序
         */
        Integer[] array = {1, 4, 2, 3, 6, 5};
        SelectionSort.reverseSort(array);
        for (int i : arr) {
            System.out.println(i);
        }

        /**
         * 测试三 自定义类
         */
        Student[] students = {
                new Student("张三", 88),
                new Student("李四", 77),
                new Student("王二", 99),
                new Student("王二", 55)
        };

        SelectionSort.sort(students);
        for (Student student : students) {
            System.out.println(student.toString());
        }

        /**
         * 排序验证
         */
        SortingUtil.sortTest("SelectionSort", students);



    }

}
