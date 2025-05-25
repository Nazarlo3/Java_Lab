package org.example;

public class Mainik {
    public static void main(String[] args) {
        // 1. Заповнюю масив парними та непарними числами
        int[] evenNumbers = new int[50];
        int[] oddNumbers = new int[50];

        for (int i = 0, even = 0, odd = 1; i < 50; i++, even += 2, odd += 2) {
            evenNumbers[i] = even;
            oddNumbers[i] = odd;
        }

        int[] array = {2, 17, 13, 6, 22, 31, 45, 66, 100, -18};

        // Перебір циклом for
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();

        // Числа з непарним індексом
        for (int j = 1; j < array.length; j += 2) {
            System.out.print(array[j] + " ");
        }
        System.out.println();

        // Числа з парним індексом
        for (int j = 0; j < array.length; j += 2) {
            System.out.print(array[j] + " ");
        }
        System.out.println();

        // Масив у зворотньому порядку
        for (int j = array.length - 1; j >= 0; j--) {
            System.out.print(array[j] + " ");
        }
        System.out.println();

        // 3. Обчислюю суми елементів масиву
        double[] realArray = {1.5, -2.3, 4.7, 3.2, -1.1, 6.8};
        double sum = 0;
        for (double num : realArray) {
            sum += num;
        }
        System.out.println("Сума елементів масиву: " + sum);

        // 4. Зміна знаку непарних елементів
        for (int j = 0; j < array.length; j++) {
            if (array[j] % 2 != 0) {
                array[j] = -array[j];
            }
        }
        System.out.print("Масив після зміни знаків непарних елементів: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }
}
