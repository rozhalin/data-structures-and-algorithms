package lesson_3;

public class CustomCollection<T> implements Linkedable<T> {

    private T[] data;
    private int head;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomCollection(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        data = (T[]) new Object[capacity];
        head = 0;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int physicalIndex(int logicalIndex) {
        if (logicalIndex < 0 || logicalIndex >= size) {
            throw new IndexOutOfBoundsException("Index: " + logicalIndex);
        }
        return (head + logicalIndex) % data.length;
    }

    private int tailIndex() {
        if (size == 0) {
            throw new IllegalStateException("Collection is empty");
        }
        return (head + size - 1) % data.length;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size < data.length) return;

        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(head + i) % data.length];
        }
        data = newData;
        head = 0;
    }

    @Override
    public void addFirst(T value) {
        ensureCapacity();
        head = (head - 1 + data.length) % data.length;
        data[head] = value;
        size++;
    }

    @Override
    public void addLast(T value) {
        ensureCapacity();
        int index = (head + size) % data.length;
        data[index] = value;
        size++;
    }

    @Override
    public void addAt(int position, T value) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position: " + position);
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        if (position == size) {
            addLast(value);
            return;
        }

        ensureCapacity();

        for (int i = size; i > position; i--) {
            int from = (head + i - 1) % data.length;
            int to = (head + i) % data.length;
            data[to] = data[from];
        }

        int physPos = (head + position) % data.length;
        data[physPos] = value;
        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("Collection is empty");
        }
        T value = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            throw new IllegalStateException("Collection is empty");
        }
        int tail = tailIndex();
        T value = data[tail];
        data[tail] = null;
        size--;
        return value;
    }

    @Override
    public T removeAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Position: " + position);
        }
        if (position == 0) {
            return removeFirst();
        }
        if (position == size - 1) {
            return removeLast();
        }

        int physPos = physicalIndex(position);
        T value = data[physPos];

        for (int i = position; i < size - 1; i++) {
            int from = (head + i + 1) % data.length;
            int to = (head + i) % data.length;
            data[to] = data[from];
        }

        int lastPhys = (head + size - 1) % data.length;
        data[lastPhys] = null;
        size--;

        return value;
    }

    @Override
    public T get(int position) {
        int idx = physicalIndex(position);
        return data[idx];
    }

    @Override
    public void set(int position, T value) {
        int idx = physicalIndex(position);
        data[idx] = value;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            int idx = (head + i) % data.length;
            if (value == null) {
                if (data[idx] == null) return i;
            } else if (value.equals(data[idx])) {
                return i;
            }
        }
        return -1;
    }
}
