package queue;

public class LinkQueue<T> {

    private class Node {
        T t;
        Node next;
    }

    private Node first;
    private Node last;
    private int N;

    public void enqueue(T t) {
        Node oldLast = last;
        last = new Node();
        last.t = t;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public T dequeue() {
        T t = first.t;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null; // 这里如果所有数据都出队列了
        }
        return t;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        LinkQueue<Integer> queue = new LinkQueue<>();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
