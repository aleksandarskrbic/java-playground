package io.github.aleksandarskrbic.handler;

import java.io.IOException;

public class LoggingHandler<T> extends DecoratedHandler<T> {

    public LoggingHandler(final Handler<T> inner) {
        super(inner);
    }

    @Override
    public void handle(final T t) throws IOException {
        System.out.println("Connected to " + t);
        try {
            super.handle(t);
        } finally {
            System.out.println("Disconnected from " + t);
        }
    }
}
