package mirea.practice.practice3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MySet<T> implements Set<T> {
    private HashSet<T> set = new HashSet<>();
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        try {
            semaphore.acquire();
            int size = set.size();
            semaphore.release();
            return size;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            boolean res = set.isEmpty();
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            boolean res = set.contains(o);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<T> iterator() {
        try {
            semaphore.acquire();
            Iterator<T> it = set.iterator();
            semaphore.release();
            return it;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object[] toArray() {
        try {
            semaphore.acquire();
            Object[] ob = set.toArray();
            semaphore.release();
            return ob;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        try {
            semaphore.acquire();
            T1[] ob = set.toArray(a);
            semaphore.release();
            return ob;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(T t) {
        try {
            semaphore.acquire();
            boolean res = set.add(t);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            boolean res = set.remove(o);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean res = set.contains(c);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        try {
            semaphore.acquire();
            boolean res = set.addAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean res = set.retainAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean res = set.removeAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            set.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
