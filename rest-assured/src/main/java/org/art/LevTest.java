package org.art;

import java.util.Scanner;

public class LevTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();

        checkOdd(number);



    }

    public static void checkOdd(int x) {

        if (x % 2 == 0) {
            System.err.println(x + " четное");
        } else {
            System.err.println(x + " нечетное");
        }
    }

}
