package org.shirakawatyu;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import java.io.*;

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
        File groupNumber = new File("." + File.separator + "config" + File.separator + "org.shirakawatyu.mc2qc" + File.separator + "groupnumber");
        File qqNumber = new File("." + File.separator + "config" + File.separator + "org.shirakawatyu.mc2qc" + File.separator + "qqnumber");
        File token = new File("." + File.separator + "config" + File.separator + "org.shirakawatyu.mc2qc" + File.separator + "token");
        if(!qqNumber.exists()){
            getLogger().info("***************************************************************************************************");
            getLogger().info("* 请在 groupnumber qqnumber token 配置文件中分别填写需要发送的群号、需要用于发消息的QQ号以及口令，然后重启mirai *");
            getLogger().info("***************************************************************************************************");
            path.mkdirs();
            try {
                token.createNewFile();
                groupNumber.createNewFile();
                qqNumber.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            new SocketFactory(groupNumber, qqNumber, token).start();
            getLogger().info("* mc2qc插件启动完成 *");
        }
    }
}

