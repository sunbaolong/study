package stack;

import java.util.Iterator;

/**
 * 使用链表来实现变长栈
 * 实现栈下压、弹出、获取大小、是否为空以及遍历功能
 */
public class LinkStack<T> implements Iterable<T> {

    private Node first; // 栈顶元素
    private int N;  // 元素数量

    public boolean isEmpty() {
        return N == 0;
//        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        Node oldNode = first;
        first = new Node();
        first.t = t;
        first.next = oldNode;
        N++;
    }

    public T pop() {
        T t = first.t;
        first = first.next;
        N--;
        return t;
    }

    private class Node {
        T t;
        Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkStackIterator();
    }

    private class LinkStackIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = current.t;
            current = current.next;
            return t;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        LinkStack<Integer> stack = new LinkStack<>();
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
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
