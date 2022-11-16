package io.github.aleksandarskrbic.handler;

import java.io.IOException;

public abstract class DecoratedHandler<T> implements Handler<T> {
    private final Handler<T> inner;

    public DecoratedHandler(final Handler<T> inner) {
        this.inner = inner;
    }

    @Override
    public void handle(final T t) throws IOException {
        inner.handle(t);
    }
}
