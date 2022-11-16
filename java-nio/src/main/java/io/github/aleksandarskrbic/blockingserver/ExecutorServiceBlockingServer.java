package io.github.aleksandarskrbic.blockingserver;

import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

import io.github.aleksandarskrbic.handler.LoggingHandler;
import io.github.aleksandarskrbic.handler.TransformHandler;
import io.github.aleksandarskrbic.handler.ExecutorServiceHandler;

public class ExecutorServiceBlockingServer {

    public static void main(final String[] args) throws IOException {
        var serverSocket = new ServerSocket(8080);
        var socketHandler =
            new ExecutorServiceHandler<>(
                new LoggingHandler<>(
                    new TransformHandler()
                ),
                Executors.newFixedThreadPool(10)
            );

        while (true) {
            final Socket socket = serverSocket.accept();
            socketHandler.handle(socket);
        }
    }
}
