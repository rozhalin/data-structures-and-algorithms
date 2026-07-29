package lesson_3;

public interface Linkedable<T> {

    int size();
    boolean isEmpty();

    void addFirst(T value);
    void addLast(T value);
    void addAt(int position, T value);

    T removeFirst();
    T removeLast();
    T removeAt(int position);

    T get(int position);
    void set(int position, T value);

    boolean contains(T value);
    int indexOf(T value);
}
