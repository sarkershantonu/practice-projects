package org.automation.server;

import javax.net.ServerSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shantonu on 9/6/16.
 */
public class LogServer {
    private static final int PORT_NUM = 9200;
    private static ServerSocketFactory serverSocketFactory = null;
    private static ServerSocket serverSocket = null;

    private static ServerSocket runServer(){
        serverSocketFactory = ServerSocketFactory.getDefault();
        try {
            serverSocket = serverSocketFactory.createServerSocket(PORT_NUM);
        } catch (IOException ignored) {
            System.err.println("Unable to create server @ "+PORT_NUM);
            System.exit(-1);
        }
        System.out.printf("LogServer running on port: %s%n", PORT_NUM);
        return serverSocket;
    }

    private static void acceptMessagesFrom(ServerSocket serverSocket){
        while (true) {
            Socket socket = null;
            String line = null;
            try {
                socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "US-ASCII"));
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException exception) {

            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException ignored) {
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        acceptMessagesFrom(runServer());
    }
}