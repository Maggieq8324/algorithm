package array;

/**
 * @Description 自定义数组
 * @author coisini
 * @date Jun 6, 2021
 * @Version 1.0
 */
public class Array<T> {

    private T[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array (int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认capacity=10
     */
    public Array () {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize () {
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity () {
        return data.length;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty () {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast (T e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst (T e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入新元素e
     * @param index
     * @param e
     */
    public void add (int index, T e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 || index < size.");
        }

        /**
         * 数组扩容
         */
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size -1; i >= index; i --) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size ++;
    }

    /**
     * 获取index索引位置元素
     * @param index
     * @return
     */
    public T get (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 获取第一个元素
     * @return
     */
    public T getFirst () {
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public T getLast () {
        return get(size -1);
    }

    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param e
     */
    void set (int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains (int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 查找数组中元素e所在的索引
     * @param e
     * @return
     */
    public int find (int e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public T remove (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        T ret = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i -1] = data[i];
        }

        size --;
        //loitering objects != memory leak
        data[size] = null;

        /**
         * 数组缩容
         */
        if (size == data.length / 4) {
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     * @return
     */
    public T removeFirst () {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     * @return
     */
    public T removeLast () {
        return remove(size -1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public boolean removeElement (int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    /**
     * 动态数组
     * @param newCapacity
     */
    private void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 重写toString
     * @return
     */
    @Override
    public String toString () {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        stringBuffer.append("[");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(data[i]);
            if (i != size - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(-1);
        System.out.println(arr);
    }

}
