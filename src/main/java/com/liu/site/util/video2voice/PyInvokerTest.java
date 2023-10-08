package com.liu.site.util.video2voice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.File;

public class PyInvokerTest {
    public void pyInvoker(String pyfilename, ArrayList<String> filenameargs) {
        String DEFAULT_PATH = "src/main/java/com/liu/site/util/video2voice/pyutil/";
        pyInvoker(pyfilename, filenameargs, DEFAULT_PATH);
    }

    public void pyInvoker(String filename, ArrayList<String> args, String filePath) {
        Path path = Paths.get(filePath);
        Process proc;

        if (Files.exists(path)) {
        } else {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("Err 无法创建文件夹: " + e.getMessage());
            }
        }
        StringBuilder s = new StringBuilder();
        for (String arg : args) {
            //参数
            s = new StringBuilder(s + " " + arg);
        }

        File file = new File(filePath + filename);
        if (!file.exists()) {
            System.out.println("Err 没有对应文件:" + filePath + filename);
            return;
        }
        try {
            proc = Runtime.getRuntime().exec("python " + filePath + filename + s);
            System.out.println("Running:python " + filePath + filename + s);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line; //此处别删除
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ArrayList<String> myargs = new ArrayList<>();
        myargs.add("WeChat_20231007161725.mp3");
        myargs.add("中文视频-教学-如何复盘");
        // myargs.add("test003");
        new PyInvokerTest().pyInvoker("audio2txt.py", myargs);
    }

}
