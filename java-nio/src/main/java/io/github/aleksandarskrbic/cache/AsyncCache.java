package io.github.aleksandarskrbic.cache;

import java.util.Optional;

public interface AsyncCache<K, V> {

    Optional<V> get(K key);
}
