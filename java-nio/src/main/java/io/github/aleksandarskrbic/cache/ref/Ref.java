package io.github.aleksandarskrbic.cache.ref;

import java.util.function.Function;

public interface Ref<T> {

    static <T> Ref<T> create(final T initial) {
        return new AtomicRefWrapper<>(initial);
    }

    T get();

    void set(T t);

    boolean compareAndSet(T expected, T update);

    default T transformAndGet(final Function<T, T> fn) {
        var oldValue = get();
        var newValue = fn.apply(oldValue);

        if (!compareAndSet(oldValue, newValue)) {
            return transformAndGet(fn);
        } else {
           return newValue;
        }
    }
}
