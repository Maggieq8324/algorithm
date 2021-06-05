package linearSearch;

/**
 * @Description 线性查找法
 * @author coisini
 * @date Jun 2, 2021
 * @Version 1.0
 */
public class LinearSearch {

    /**
     * 私有构造函数，该类不被别人创建，直接使用该类的search函数
     */
    private LinearSearch(){}

    /**
     * 泛型线性查找
     * 于自定义的类，要重写equals方法
     * @param data
     * @param target
     * @param <T>
     * @return
     */
    public static <T> int search(T[] data, T target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        /**
         * 测试一
         */
        Integer[] data = {11, 12, 66, 34, 65, 36, 60};
        int result = LinearSearch.search(data, 34);
        System.out.println(result);

        /**
         * 测试二 自定义类
         */
        Student[] students = {
                new Student("1", "张三"),
                new Student("2", "李四"),
                new Student("3", "王二")
        };

        System.out.println(LinearSearch.search(students, new Student("3", "王二")));
    }

}
