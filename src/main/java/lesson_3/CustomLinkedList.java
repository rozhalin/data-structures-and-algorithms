package lesson_3;

public class CustomLinkedList<T> implements Linkedable<T> {
    private Element<T> head;
    private Element<T> tail;
    private int size;

    private static class Element<T> implements Node<T> {
        T value;
        Element<T> prev;
        Element<T> next;

        public Element(T v) {
            this.value = v;
        }

        @Override
        public T getValue() {
            return this.value;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T value) {
        Element<T> n = new Element<>(value);
        n.next = head;
        if (head != null) head.prev = n;
        head = n;
        if (tail == null) tail = n;
        size++;
    }

    public void addLast(T value) {
        Element<T> n = new Element<>(value);
        n.prev = tail;
        if (tail != null) tail.next = n;
        tail = n;
        if (head == null) head = n;
        size++;
    }

    @Override
    public void addAfter(Node<T> node, T value) {
        Element<T> current = (Element<T>)node;
        Element<T> newElement = new Element<>(value);

        newElement.next = current.next;
        newElement.prev = current;

        if (current.next != null) {
            current.next.prev = newElement;
        }
        current.next = newElement;
        if (current == this.tail) {
            this.tail = newElement;
        }

        size++;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public int indexOf(T value) {
        int idx = 0;
        for (Element<T> cur = head; cur != null; cur = cur.next, idx++) {
            if ((value == null && cur.value == null) ||
                    (value != null && value.equals(cur.value))
            )
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

    public T remove(Node<T> node) {
        Element<T> element = (Element<T>) node;
        T value = ((Element<T>) node).value;

        if (element == this.head) {
            removeFirst();
            return value;
        }

        if (element == this.tail) {
            removeLast();
            return value;
        }

        element.prev.next = element.next;
        element.next.prev = element.prev;

        size--;
        return value;
    }

    public T get(int index) {
        Element<T> cur = nodeAt(index);
        return cur != null ? cur.value : null;
    }

    public void set(int index, T value) {
        Element<T> cur = nodeAt(index);
        if (cur != null) cur.value = value;
    }

    private Element<T> nodeAt(int index) {
        if (index < 0 || index >= size) return null;
        Element<T> cur;

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
