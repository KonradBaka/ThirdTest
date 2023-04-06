package pl.kurs.exercise4.app;

import pl.kurs.exercise4.model.MinMax;
import pl.kurs.exercise4.service.MinMaxService;

import java.util.ArrayList;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);


        List<String> stringList = new ArrayList<>();

        stringList.add("Paweł");
        stringList.add("Piotr");
        stringList.add("Adam");
        stringList.add("Konrad");
        stringList.add("Michał");
        stringList.add("Waldemar");


        System.out.println(MinMaxService.getMinAndMax(intList));
        System.out.println(MinMaxService.getMinAndMax(stringList));

    }
}
