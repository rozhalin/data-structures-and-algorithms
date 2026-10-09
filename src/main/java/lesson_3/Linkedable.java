package lesson_3;

public interface Linkedable<T> {

    int size();
    boolean isEmpty();

    void addFirst(T value);
    void addLast(T value);
    void addAfter(Node<T> node, T value);

    T removeFirst();
    T removeLast();
    T remove(Node<T> node);

    T get(int position);
    void set(int position, T value);

    boolean contains(T value);
    int indexOf(T value);
}
