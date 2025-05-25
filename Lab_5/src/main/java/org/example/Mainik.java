import java.util.Scanner;

public class Mainik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Обчислення площі трапеції
        System.out.println("Введіть основу a, основу b і висоту h трапеції:");
        double a = getValidDouble(scanner);
        double b = getValidDouble(scanner);
        double h = getValidDouble(scanner);
        System.out.println("Площа трапеції: " + calculateTrapezoidArea(a, b, h));

        // 2. Пошук найменшого числа серед трьох
        System.out.println("Введіть три числа для знаходження найменшого:");
        double num1 = getValidDouble(scanner);
        double num2 = getValidDouble(scanner);
        double num3 = getValidDouble(scanner);
        System.out.println("Найменше число: " + findMinNumber(num1, num2, num3));

        // 3. Вивід масиву
        int[] array = {2, 17, 13, 6, 22, 31, 45, 66, 100, -18};
        System.out.println("Масив елементів:");
        printArray(array);

        // 4. Пошук найбільшого числа у масиві
        System.out.println("Найбільше число в масиві: " + findMaxNumber(array));

        scanner.close();
    }

    // Метод для обчислення площі трапеції
    public static double calculateTrapezoidArea(double a, double b, double h) {
        return (a + b) / 2 * h;
    }

    // Метод для знаходження найменшого числа
    public static double findMinNumber(double num1, double num2, double num3) {
        return Math.min(num1, Math.min(num2, num3));
    }

    // Метод для виводу масиву
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Метод для знаходження найбільшого числа у масиві
    public static int findMaxNumber(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Метод для перевірки введених чисел
    public static double getValidDouble(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Помилка! Введіть коректне число:");
                scanner.next();
            }
        }
    }
}
