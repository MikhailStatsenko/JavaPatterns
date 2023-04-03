package com.pw12.pw12;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileWorker {
    private File inputFile, outputFile;
    private String inputPath;

    public FileWorker() {
        System.out.println("FileWorker created");
    }

    @PostConstruct
    private void init() {
        System.out.println("PostConstruct");
    }

    public void start(String inputPath, String outputPath) {
        System.out.println("Method start");
        this.inputPath = inputPath;
        inputFile = new File(inputPath);
        outputFile = new File(outputPath);
        hash();
    }

    public void hash() {
        System.out.println("Method hash");
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            if (inputFile.exists())
                fileWriter.write(DigestUtils.md5DigestAsHex(Files.readAllBytes(Paths.get(inputPath))));
            else
                fileWriter.write("null");

            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    private void  destroy() {
        System.out.println("PreDestroy");
        if (inputFile.exists())
            inputFile.delete();
    }

}
