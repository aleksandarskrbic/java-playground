package io.github.aleksandarskrbic.blockingserver;

import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;

import io.github.aleksandarskrbic.handler.LoggingHandler;
import io.github.aleksandarskrbic.handler.TransformHandler;

public class SingleThreadedBlockingServer {
    public static void main(final String[] args) throws IOException {
        var serverSocket = new ServerSocket(8080);
        var socketHandler =
            new LoggingHandler<>(
                new TransformHandler()
            );

        while (true) {
            final Socket socket = serverSocket.accept();
            socketHandler.handle(socket);
        }
    }
}