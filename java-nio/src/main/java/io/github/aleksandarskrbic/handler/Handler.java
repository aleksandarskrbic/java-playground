package io.github.aleksandarskrbic.handler;

import java.io.IOException;

public interface Handler<T> {
    void handle(T t) throws IOException;
}
