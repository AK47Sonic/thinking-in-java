package com.sonic.juc.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashSetQuestion
 *
 * @author Sonic
 * @since 2019/4/10
 */
public class ConcurrentHashSetQuestion {

    public static void main(String[] args) {

    }

    private static class ConcurrentHashSet<E> implements Set<E> {

        private final ConcurrentHashMap<E, Object> map = new ConcurrentHashMap<>();
        private final Object object = new Object();

        private Set<E> keySet(){
            return map.keySet();
        }

        @Override
        public int size() {
            return keySet().size();
        }

        @Override
        public boolean isEmpty() {
            return keySet().isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return keySet().contains(o);
        }

        @Override
        public Iterator<E> iterator() {
            return keySet().iterator();
        }

        @Override
        public Object[] toArray() {
            return keySet().toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return keySet().toArray(a);
        }

        @Override
        public boolean add(E e) {
            return map.put(e, object) == null;
        }

        @Override
        public boolean remove(Object o) {
            return map.remove(o) == object;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return keySet().containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return keySet().addAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return keySet().retainAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return keySet().retainAll(c);
        }

        @Override
        public void clear() {
            map.clear();
        }
    }

}
