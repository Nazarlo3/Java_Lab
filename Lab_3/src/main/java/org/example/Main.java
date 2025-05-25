package org.example;

public class Main {
    public static void main(String[] args) {
        // 1. Виводжу фразу 50 разів
        String phrase = "Hello, Java!";

        for (int i = 0; i < 50; i++) {
            System.out.println(phrase);
        }

        int count = 0;
        while (count < 50) {
            System.out.println(phrase);
            count++;
        }

        // 2. Виводжу години і хвилини з for
        for (int h = 0; h <= 2; h++) {
            for (int m = 0; m < 60; m++) {
                System.out.println(h + " h " + m + " min");
            }
        }

        int h = 0, m = 0;
        while (h <= 2) {
            while (m < 60) {
                System.out.println(h + " h " + m + " min");
                m++;
            }
            h++;
            m = 0;
        }

        // 4. Вивести години, хвилини і секунди
        for (int hour = 0; hour <= 2; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                for (int second = 0; second < 60; second++) {
                    System.out.println(hour + " h " + minute + " min " + second + " sec");
                }
            }
        }

        // 5. Табуляція функції f(x) = 2x sin(x) - cos(x)
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введіть нижню границю діапазону (1 число): ");
        double lowerBound = scanner.nextDouble();
        System.out.print("Введіть верхню границю діапазону (1 число): ");
        double upperBound = scanner.nextDouble();

        double step = 0.2;
        int countValues = 0;

        System.out.println("Табуляція функції (for loop):");
        for (double x = -2; x <= 2; x += step) {
            double y = 2 * x * Math.sin(x) - Math.cos(x);
            System.out.println("f(" + x + ") = " + y);
            if (y >= lowerBound && y <= upperBound) countValues++;
        }

        System.out.println("Табуляція функції (while loop):");
        double x = -2;
        while (x <= 2) {
            double y = 2 * x * Math.sin(x) - Math.cos(x);
            System.out.println("f(" + x + ") = " + y);
            if (y >= lowerBound && y <= upperBound) countValues++;
            x += step;
        }

        if (countValues > 0) {
            System.out.println("Кількість значень у вказаному діапазоні: " + countValues);
        } else {
            System.out.println("Значень у вказаному діапазоні немає.");
        }
    }
}
