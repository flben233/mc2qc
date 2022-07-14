package org.shirakawatyu;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Group;
import org.shirakawatyu.utils.Md5Util;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static org.shirakawatyu.utils.FileUtil.readFile;

class Process extends Thread {
    File groupNumber;
    File qqNumber;
    File token;
    Socket socket;

    public Process(File groupNumber, File qqNumber, Socket socket, File token) {
        this.token = token;
        this.groupNumber = groupNumber;
        this.qqNumber = qqNumber;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String tok = dis.readUTF().trim();
            String tokenStr = Md5Util.toMd5String(new Scanner(this.token).next().trim());
            if (!tokenStr.equals(tok.trim())) {
                System.out.println("【mc2qc】密码错误，连接即将断开！");
                socket.close();
            } else {
                Group g = Bot.getInstance(Long.parseLong(readFile(qqNumber))).getGroup(Long.parseLong(readFile(groupNumber)));
                System.out.println("【mc2qc】连接已建立");
                while (true) {
                    Thread.sleep(100);
                    if (dis.available() > 0) {
                        g.sendMessage(dis.readUTF());
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
