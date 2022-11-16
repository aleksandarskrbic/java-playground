package io.github.aleksandarskrbic.handler;

public class ThreadedHandler<T> extends UncheckedIOExceptionConverterHandler<T> {

    public ThreadedHandler(final Handler<T> handler) {
        super(handler);
    }

    @Override
    public void handle(final T t) {
        new Thread(() -> super.handle(t)).start();
    }
}
