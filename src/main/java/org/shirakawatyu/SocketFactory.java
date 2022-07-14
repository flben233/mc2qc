package org.shirakawatyu;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class SocketFactory extends Thread {
    File groupnumber;
    File qqnumber;
    File token;

    public SocketFactory(File groupnumber, File qqnumber, File token) {
        this.groupnumber = groupnumber;
        this.qqnumber = qqnumber;
        this.token = token;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(25555);
            while (true) {
                Socket socket = server.accept();
                new Process(groupnumber, qqnumber, socket, token).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
