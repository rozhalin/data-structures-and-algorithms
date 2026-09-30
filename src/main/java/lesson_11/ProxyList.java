package lesson_11;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProxyList<E> implements List<E> {

    private final List<E> lst;
    private int addCallCounter = 0;

    public int getAddCallCounter() {
        return addCallCounter;
    }

    public ProxyList(List<E> lst) {
        this.lst = lst;
    }

    @Override
    public int size() {
        return this.lst.size();
    }

    @Override
    public boolean isEmpty() {
        return this.lst.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.lst.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return this.lst.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.lst.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.lst.toArray(a);
    }

    @Override
    public boolean add(E e) {
        addCallCounter++;
        return this.lst.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return this.lst.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.lst.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return this.lst.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return this.lst.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.lst.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.lst.retainAll(c);
    }

    @Override
    public void clear() {
        this.lst.clear();
    }

    @Override
    public E get(int index) {
        return this.lst.get(index);
    }

    @Override
    public E set(int index, E element) {
        return this.lst.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        addCallCounter++;
        this.lst.add(index, element);
    }

    @Override
    public E remove(int index) {
        return this.lst.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.lst.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.lst.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return this.lst.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return this.lst.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return this.lst.subList(fromIndex, toIndex);
    }
}
