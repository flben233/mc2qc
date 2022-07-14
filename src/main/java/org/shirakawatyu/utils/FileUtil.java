package org.shirakawatyu.utils;

import java.io.File;
import java.util.Scanner;

public class FileUtil {
    public static String readFile(File file) {
        String str = "";
        try {
            Scanner sc = new Scanner(file);
            str = sc.next().trim();
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
