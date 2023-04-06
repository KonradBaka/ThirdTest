package pl.kurs.exercise2.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class FileByDaysRunner {
    public static void main(String[] args) {

//        Poniedziałek: 61
//        Wtorek: 77
//        Środa: 44
//        Czwartek: 160
//        Piątek: 5
//        Sobota: 2
//        Niedziela: 7
//        Ale ćwicze jeszcze na stronkach :')

        List<File> myJavaFiles = new ArrayList<>();
        addFilesToList(new File("C:\\Users\\user\\IdeaProjects"), myJavaFiles);

        printDaysWithResult(myJavaFiles);

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

    static void printDaysWithResult(List<File> list) {
        DayOfWeek day;
        int monday = 0;
        int tuesday = 0;
        int wednesday = 0;
        int thursday = 0;
        int friday = 0;
        int saturday = 0;
        int sunday = 0;

        for (File f : list) {
            day = getDayFromFile(f);
            switch (day) {
                case MONDAY:
                    monday++;
                    break;
                case TUESDAY:
                    tuesday++;
                    break;
                case WEDNESDAY:
                    wednesday++;
                    break;
                case THURSDAY:
                    thursday++;
                    break;
                case FRIDAY:
                    friday++;
                    break;
                case SATURDAY:
                    saturday++;
                    break;
                case SUNDAY:
                    sunday++;
                    break;
            }
        }

        System.out.println("Poniedziałek: " + monday);
        System.out.println("Wtorek: " + tuesday);
        System.out.println("Środa: " + wednesday);
        System.out.println("Czwartek: " + thursday);
        System.out.println("Piątek: " + friday);
        System.out.println("Sobota: " + saturday);
        System.out.println("Niedziela: " + sunday);
        System.out.println("Ale ćwicze jeszcze na stronkach :')");
    }

    static DayOfWeek getDayFromFile(File file) {

        BasicFileAttributes bfa = null;
        try {
            bfa = Files.readAttributes(Path.of(file.getAbsolutePath()), BasicFileAttributes.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Instant instant = bfa.creationTime().toInstant();
        LocalDate ld = LocalDate.ofInstant(instant, ZoneOffset.UTC);
        return ld.getDayOfWeek();
    }
}
