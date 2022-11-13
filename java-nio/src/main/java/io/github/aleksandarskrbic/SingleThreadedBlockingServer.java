package io.github.aleksandarskrbic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedBlockingServer {
    public static void main(final String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            final Socket socket = serverSocket.accept();
            handle(socket);
        }
    }

    private static void handle(final Socket socket) throws IOException {
        System.out.println("Connected to " + socket);
        try (
            socket;
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream()
        ) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(transform(data));
            }
        } finally {
            System.out.println("Disconnected from " + socket);
        }
    }

    private static int transform(final int data) {
        System.out.println(data);
        return Character.isLetter(data) ? data ^ ' ' : data;
    }
}