package org.example;

import java.io.*; // Імпортуємо класи для роботи з файлами

public class FileHandler {
    private final String fileName; // Зберігає ім'я файлу

    // Конструктор, який приймає ім'я файлу
    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    // Метод для запису чисел у файл
    public void writeNumbersToFile(int[] numbers) {
        try (FileWriter writer = new FileWriter(fileName)) { // FileWriter автоматично створює файл, якщо його не існує
            for (int number : numbers) {
                writer.write(number + " "); // Записуємо кожне число через пробіл
            }
            System.out.println("Числа успішно записані у файл: " + fileName);

            // Перевіряємо, чи підтримується відкриття файлів через Desktop API
            if (java.awt.Desktop.isDesktopSupported()) {
                try {
                    java.awt.Desktop.getDesktop().open(new java.io.File(fileName)); // Відкриваємо файл після запису
                } catch (IOException e) {
                    System.out.println("Не вдалося відкрити файл: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    // Метод для читання чисел з файлу
    public void readNumbersFromFile() {
        try (FileReader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) { // BufferedReader читає рядки з файлу
            String line = bufferedReader.readLine(); // Читаємо перший рядок з файлу
            System.out.println("Прочитані числа: " + line);
        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні файлу: " + e.getMessage());
        }
    }
}