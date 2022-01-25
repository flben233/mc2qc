package org.shirakawatyu;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.BotOnlineEvent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public final class Mc2qc extends JavaPlugin {
    public static final Mc2qc INSTANCE = new Mc2qc();

    private Mc2qc() {
        super(new JvmPluginDescriptionBuilder("org.shirakawatyu.mc2qc", "1.0-SNAPSHOT")
                .name("mc2qc")
                .author("ShirakawaTyu")
                .build());
    }

    @Override
    public void onEnable() {
        File path = new File("." + File.separator + "config" + File.separator + "org.shirakawatyu.mc2qc");
        File groupnumber = new File("." + File.separator + "config" + File.separator + "org.shirakawatyu.mc2qc" + File.separator + "groupnumber");
        File qqnumber = new File("." + File.separator + "config" + File.separator + "org.shirakawatyu.mc2qc" + File.separator + "qqnumber");
        if(!qqnumber.exists()){
            getLogger().info("******************************************************************************************");
            getLogger().info("* 请在 groupnumber qqnumber 两个配置文件中分别填写需要发送的群号、需要用于发消息的QQ号，然后重启mirai *");
            getLogger().info("******************************************************************************************");
            path.mkdirs();
            try {
                groupnumber.createNewFile();
                qqnumber.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            new SocketFactory(groupnumber, qqnumber).start();
            getLogger().info("* mc2qc插件启动完成 *");
        }
    }
}

class SocketFactory extends Thread{
    File groupnumber;
    File qqnumber;
    public SocketFactory (File groupnumber,File qqnumber){
        this.groupnumber = groupnumber;
        this.qqnumber = qqnumber;
    }
    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(25555);
            while (true) {
                Socket socket = server.accept();
                new Process(groupnumber,qqnumber,socket).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class Process extends Thread{
    private File groupnumber;
    private File qqnumber;
    Socket socket;
    public Process(File groupnumber,File qqnumber,Socket socket){
        this.groupnumber = groupnumber;
        this.qqnumber = qqnumber;
        this.socket = socket;
    }
    @Override
    public void run() {
                try{
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    Group g = Bot.getInstance(Long.parseLong(readFile(qqnumber))).getGroup(Long.parseLong(readFile(groupnumber)));
                while (true) {
                    Thread.sleep(100);
                    if(dis.available() > 0){
                        g.sendMessage(dis.readUTF());
                    }
                }}catch (IOException e){
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    }
    public static String readFile(File file) {
        String str = "";
        try {
            FileReader fr = new FileReader(file);
            int i;
            while((i = fr.read()) != -1){
                str += (char)i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.trim();
    }
}