package TIC2002.test;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class FileReadingDemo {
    private static void printFileContents(String filePath) throws FileNotFoundException {
        System.out.println(new File(".").getAbsoluteFile());
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
    }

    private static List<String> getLines(String filePath) throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            lines.add(s.nextLine());
        }
        return lines;
    }

    public static void main(String[] args) {
        try {
//            String filePath = "data/fruits.txt";
            String filePath = "data/tasks.txt";
//            printFileContents(filePath);
            for (String s : getLines(filePath)) {
                if (s.charAt(0) == 'T') {
                    System.out.println(s);
                } else if (s.charAt(0) == 'D') {
                    System.out.println("Deadline: " + s);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
}
