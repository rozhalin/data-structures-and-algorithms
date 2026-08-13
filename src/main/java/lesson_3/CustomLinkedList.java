package lesson_3;

public class CustomLinkedList<T> implements Linkedable<T> {

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;
        Node(T v) { this.value = v; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T value) {
        Node<T> n = new Node<>(value);
        n.next = head;
        if (head != null) head.prev = n;
        head = n;
        if (tail == null) tail = n;
        size++;
    }

    public void addLast(T value) {
        Node<T> n = new Node<>(value);
        n.prev = tail;
        if (tail != null) tail.next = n;
        tail = n;
        if (head == null) head = n;
        size++;
    }

    public void addAt(int index, T value) {
        if (index <= 0) {
            addFirst(value);
            return;
        }
        if (index >= size) {
            addLast(value);
            return;
        }

        Node<T> cur = nodeAt(index);
        Node<T> n = new Node<>(value);
        Node<T> prev = cur.prev;
        n.prev = prev;
        n.next = cur;
        cur.prev = n;
        if (prev != null) {
            prev.next = n;
        } else {
            head = n;
        }
        size++;
    }

    public boolean contains(T value) {
        for (Node<T> cur = head; cur != null; cur = cur.next) {
            if ((value == null && cur.value == null) || (value != null && value.equals(cur.value)))
                return true;
        }
        return false;
    }

    public int indexOf(T value) {
        int idx = 0;
        for (Node<T> cur = head; cur != null; cur = cur.next, idx++) {
            if ((value == null && cur.value == null) || (value != null && value.equals(cur.value)))
                return idx;
        }
        return -1;
    }

    public T removeFirst() {
        if (head == null) return null;
        T v = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return v;
    }

    public T removeLast() {
        if (tail == null) return null;
        T v = tail.value;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return v;
    }

    public T removeAt(int index) {
        Node<T> cur = nodeAt(index);
        if (cur == null) return null;
        T v = cur.value;
        Node<T> p = cur.prev;
        Node<T> n = cur.next;
        if (p != null) {
            p.next = n;
        } else {
            head = n;
        }
        if (n != null) {
            n.prev = p;
        } else {
            tail = p;
        }
        size--;
        return v;
    }

    public T get(int index) {
        Node<T> cur = nodeAt(index);
        return cur != null ? cur.value : null;
    }

    public void set(int index, T value) {
        Node<T> cur = nodeAt(index);
        if (cur != null) cur.value = value;
    }

    private Node<T> nodeAt(int index) {
        if (index < 0 || index >= size) return null;
        Node<T> cur;

        if (index <= size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) cur = cur.next;
        } else {
            cur = tail;
            for (int i = size - 1; i > index; i--) cur = cur.prev;
        }
        return cur;
    }
}
