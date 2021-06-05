package linearSearch;

/**
 * @Description 测试类
 * @author coisini
 * @date Jun 2, 2021
 * @Version 1.0
 */
public class Student {

    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * 重新equals方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            //地址相等
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        /**
         * 需要比较的字段相等，则这两个对象相等
         */
        Student other = (Student) obj;
        return this.name.equals(other.name) && this.id.equals(other.id);

    }

}
