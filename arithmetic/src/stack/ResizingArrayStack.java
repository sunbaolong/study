package stack;

import java.util.Iterator;

/**
 * 使用数组来实现变长栈
 * 实现栈下压、弹出、获取大小、是否为空以及遍历功能
 */
public class ResizingArrayStack<T> implements Iterable {

    private T[] arr = (T[]) new Object[5];  // 初始大小为5
    private int N;                          // 栈元素数量

    /**
     * 返回栈是否为空，如果N索引为0则代表栈是空的
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回栈元素数量，即为N
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 下压栈，判断当数组满了，则无法再添加数据了，需要先进行扩容
     * @param t
     */
    public void push(T t) {
        if (N == arr.length) {
            resize(2 * N);
        }
        arr[N++] = t;
    }

    /**
     * 弹出最近压入的数据
     * @return
     */
    public T pop() {
        T t = arr[--N];
        arr[N] = null;
        if (N > 0 && N == arr.length/4) {
            resize(arr.length/2);
        }
        return t;
    }

    /**
     * 将栈当前数组移动到一个新的数组中
     * @param max
     */
    private void resize(int max) {
        T[] tmp = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return arr[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
