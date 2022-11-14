package io.github.aleksandarskrbic.cache.ref;

import java.util.concurrent.atomic.AtomicReference;

final class AtomicRefWrapper<T> implements Ref<T> {

    private final AtomicReference<T> inner;

    public AtomicRefWrapper(final T initial) {
        this.inner = new AtomicReference<>(initial);
    }

    @Override
    public T get() {
        return inner.get();
    }

    @Override
    public void set(final T t) {
        inner.set(t);
    }

    @Override
    public boolean compareAndSet(final T expected, final T update) {
        return inner.compareAndSet(expected, update);
    }
}
