package pl.kurs.exercise3.app;

import java.util.Arrays;

public class FibonacciRunner {
    public static void main(String[] args) {

        System.out.println(getFibonacciIndex(21));

    }

    public static int getFibonacciIndex(int number) {
        if (number <= 0) {
            return 0;
        }

        int a = 1;
        int b = 0;
        int c = 0;

        while (a < number) {
            int next = a + b;
            b = a;
            a = next;
            c++;
        }

        if (a == number) {
            return c + 1;
        } else {
            return -1;
        }
    }
}
