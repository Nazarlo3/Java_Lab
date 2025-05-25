package org.example;

import java.util.Random; // Для генерації випадкових чисел

public class RandomNumberGenerator {
    private final int lowerBound; // Нижня межа діапазону
    private final int upperBound; // Верхня межа діапазону
    private final int count;      // Кількість чисел

    // Конструктор для ініціалізації меж і кількості чисел
    public RandomNumberGenerator(int lowerBound, int upperBound, int count) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.count = count;
    }

    // Метод, що генерує масив випадкових чисел
    public int[] generateNumbers() {
        int[] numbers = new int[count]; // Створюємо масив потрібного розміру
        Random random = new Random(); // Створюємо генератор випадкових чисел

        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // Генеруємо число у діапазоні
        }

        return numbers; // Повертаємо масив
    }
}