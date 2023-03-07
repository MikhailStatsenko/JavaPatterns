package PW3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class MySet<E> implements Set<E> {
    private volatile Set<E> set = new HashSet<>();
    private Semaphore semaphore = new Semaphore(1);
    @Override
    public Spliterator<E> spliterator() {
        return Set.super.spliterator();
    }

    @Override
    public int size() {
        int size;
        try {
            semaphore.acquire();
            size = set.size();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty;
        try {
            semaphore.acquire();
            isEmpty = set.isEmpty();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return isEmpty;
    }

    @Override
    public boolean contains(Object o) {
        boolean contains;
        try {
            semaphore.acquire();
            contains = set.contains(o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return contains;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator;
        try {
            semaphore.acquire();
            iterator = set.iterator();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] arr;
        try {
            semaphore.acquire();
            arr = set.toArray();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] arr;
        try {
            semaphore.acquire();
            arr = set.toArray(a);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return arr;
    }

    @Override
    public boolean add(E e) {
        boolean added;
        try {
            semaphore.acquire();
            added = set.add(e);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            semaphore.release();
        }
        return added;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed;
        try {
            semaphore.acquire();
            removed = set.remove(o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return removed;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean contains;
        try {
            semaphore.acquire();
            contains = set.containsAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return contains;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean added;
        try {
            semaphore.acquire();
            added = set.addAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return added;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean retained;
        try {
            semaphore.acquire();
            retained = set.retainAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return retained;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed;
        try {
            semaphore.acquire();
            removed = set.removeAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return removed;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            set.clear();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
