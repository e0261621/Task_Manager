package tic2002.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingDemo {
    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    private static void writeTasks(String filePath, String task) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);

        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        if (s.hasNext()) {
            fw.write("\r\n");
        }
        fw.write(task);
        fw.close();
    }

    public static void main(String[] args) {
        String file2 = "temp/lines.txt";
        try {
//            writeToFile(file2, "first line" + System.lineSeparator() + "second line");
            //Use java obj.getClass

            writeTasks(file2, "T" + " | " + "1" + " | " + "read book");
            writeTasks(file2, "D" + " | " + "0" + " | " + "read book" + " | " + "Friday 6pm");
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
