package io.github.aleksandarskrbic.handler;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutorService;

public class ExecutorServiceHandler<T> extends DecoratedHandler<T> {

    private final ExecutorService pool;
    private final Thread.UncaughtExceptionHandler exceptionHandler;

    public ExecutorServiceHandler(
        final Handler<T> inner,
        final ExecutorService pool,
        final Thread.UncaughtExceptionHandler exceptionHandler) {
        super(inner);
        this.pool = pool;
        this.exceptionHandler = exceptionHandler;
    }

    public ExecutorServiceHandler(final Handler<T> inner, final ExecutorService pool) {
        this(inner, pool, (t, e) -> System.out.println("uncaught: " + t + " error: " + e));
    }

    @Override
    public void handle(final T t) {
        pool.submit(new FutureTask<>(() -> {
            super.handle(t);
            return null;
        }) {
            @Override
            protected void setException(final Throwable t) {
                exceptionHandler.uncaughtException(Thread.currentThread(), t);
            }
        });
    }
}
