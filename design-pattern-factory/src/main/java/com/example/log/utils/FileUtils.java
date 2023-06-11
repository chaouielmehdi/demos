package com.example.log.utils;

import java.io.*;

public class FileUtils {
    private static final boolean APPEND = true;

    public static void create(String pathname) {
        File file = new File(pathname);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String pathname, String message) {
        try(FileWriter fileWriter = new FileWriter(pathname, APPEND)) {
            writeLine(fileWriter, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeLine(FileWriter fileWriter, String message) throws IOException {
        fileWriter.write(message);
        fileWriter.write("\n");
    }
}
