package io.github.aleksandarskrbic.handler;

import java.io.IOException;
import java.io.UncheckedIOException;

public class UncheckedIOExceptionConverterHandler<T> extends DecoratedHandler<T> {

    public UncheckedIOExceptionConverterHandler(final Handler<T> inner) {
        super(inner);
    }

    @Override
    public void handle(final T t) {
        try {
            super.handle(t);
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
