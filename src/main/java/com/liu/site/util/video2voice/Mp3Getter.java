package com.liu.site.util.video2voice;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Mp3Getter {
    public void getMp3(ArrayList<String> FileNames) {
        String SourcePath = "src/main/java/com/liu/site/util/video2voice/mp4/";
        getMp3(FileNames, SourcePath);

    }

    public void getMp3(ArrayList<String> FileNames, String SourcePath) {
        if (SourcePath == null || SourcePath.isEmpty()) {
            SourcePath = "src/main/java/com/liu/site/util/video2voice/mp4/";
        }
        for (String element : FileNames) {
            Path filePath = Paths.get(SourcePath + element);
            if (!(filePath).toFile().exists()) {
                System.out.println(filePath + ",ERR,文件不存在! 跳过");
            } else {
                doIt(SourcePath + element);
            }
        }
    }

    public void doIt(String FileName) {
        String DesPath = "src/main/java/com/liu/site/util/video2voice/mp3/";
        doIt(FileName, DesPath);
    }

    public void doIt(String FileName, String DesPath) {
        if (DesPath == null || DesPath.isEmpty()) {
            DesPath = "src/main/java/com/liu/site/util/video2voice/mp3/";
        }
        Path path = Paths.get(DesPath);

        if (Files.exists(path)) {
            int test = 0;
        }
        else {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("无法创建文件夹: " + e.getMessage());
            }
        }

        try {
            //抓取资源
            FFmpegFrameGrabber frameGrabber1 = new FFmpegFrameGrabber(FileName);
            FFmpegFrameRecorder recorder = null;
            Frame frame = null;
            String fileName = null;
            frameGrabber1.start();
            // 输出位置
            fileName = DesPath + new File(FileName).getName().replace(".mp4",".mp3");
            System.out.println("--文件名-->>" + fileName);
            recorder = new FFmpegFrameRecorder(fileName, frameGrabber1.getAudioChannels());
            recorder.setFormat("mp3");
            recorder.setSampleRate(frameGrabber1.getSampleRate());
            recorder.setTimestamp(frameGrabber1.getTimestamp());
            recorder.setAudioQuality(0);

            recorder.start();
            int index = 0;
            while (true) {
                frame = frameGrabber1.grab();
                if (frame == null) {
                    System.out.println("视频处理完成");
                    break;
                }
                if (frame.samples != null) {
                    recorder.recordSamples(frame.sampleRate, frame.audioChannels, frame.samples);
                }
                // System.out.println("帧值=" + index);
                index++;
            }
            recorder.stop();
            recorder.release();
            frameGrabber1.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        ArrayList<String> files = new ArrayList<>();
        files.add("test2.mp4");
        files.add("test.mp4");
        files.add("test3.mp4");
        files.add("1245307281-1-192.mp4");
        files.add("1245307281-1-192.mp4");
        new Mp3Getter().getMp3(files);
    }
}
