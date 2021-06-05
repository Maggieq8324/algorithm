package insertionSort;

import selectionSort.Student;

/**
 * @Description 插入排序算法
 * @author coisini
 * @date Jun 4, 2021
 * @Version 1.0
 */
public class InsertionSort {

    /**
     * 私有构造函数，该类不被别人创建，直接使用该类的sort函数
     */
    private InsertionSort () {}

    /**
     * 插入排序算法
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort (T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 将 arr[i] 插入到合适的位置
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j-1);
                }
            }

        }
    }

    /**
     * 插入排序算法优化
     * 记录插入元素，只进行一次赋值
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void sortOptimize (T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 暂存arr[i],如果arr[i]小于arr[j-1],则将arr[j-1]后移,最后赋值j
            T t = arr[i];
            int j;
            for (j = i; j > 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }

            arr[j] = t;
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

    public static void main(String[] args) {
        /**
         * 测试一
         */
        Integer[] arr = {3, 5, 7, 1, 2, 4, 9, 8, 6};
        InsertionSort.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        /**
         * 测试二 自定义类
         */
        Student[] students = {
                new Student("张三", 88),
                new Student("李四", 77),
                new Student("王二", 99),
                new Student("刘一", 55)
        };

        InsertionSort.sort(students);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

}
