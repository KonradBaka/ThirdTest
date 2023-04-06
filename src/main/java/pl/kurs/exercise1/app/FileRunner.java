package pl.kurs.exercise1.app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileRunner {
    public static void main(String[] args) {

        List<File> myJavaFiles = new ArrayList<>();
        addFilesToList(new File("C:\\Users\\user\\IdeaProjects"), myJavaFiles);


        System.out.println("Najwiekszy plik o rozszerzeniu .java: " + findLargestJavaFile(myJavaFiles));

    }

    static void addFilesToList(File dir, List<File> list) {
        File[] file = dir.listFiles();
        for (File f : file) {
            if (f.isDirectory()) {
                addFilesToList(f, list);
            } else if (f.getName().endsWith(".java")) {
                list.add(f);
            }
        }
    }

    static File findLargestJavaFile(List<File> list) {

        File largestJavaFile = null;
        long largestFileSize = 0;

        for (File f : list) {
            if (f.getName().endsWith(".java") && f.length() > largestFileSize) {
                largestJavaFile = f;
                largestFileSize = f.length();
            }
        }
        return largestJavaFile;
    }

}
