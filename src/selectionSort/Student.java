package selectionSort;

/**
 * @Description 测试类
 * @author coisini
 * @date Jun 2, 2021
 * @Version 1.0
 */
public class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * 重写compareTo方法
     * @param another
     * @return
     */
    @Override
    public int compareTo (Student another) {
        // 从小到大排序
        return this.score - another.score;

        // 从大到小排序
        // return another.score - this.score;
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString () {
        return String.format("Studen(name: %s, socre: %d)", this.name, this.score);
    }

}
