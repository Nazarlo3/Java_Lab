package org.example;

public class Mainik {
    public static void main(String[] args) {
        // Перевіряю, чи передано достатньо аргументів командного рядка
        if (args.length < 4) {
            System.out.println("Використання: java Main <ім'я файлу> <нижня межа> <верхня межа> <кількість чисел>");
            return;
        }

        // Зчитую параметри з командного рядка
        String fileName = args[0]; // Ім'я файлу
        int lowerBound = Integer.parseInt(args[1]); // Нижня межа діапазону
        int upperBound = Integer.parseInt(args[2]); // Верхня межа діапазону
        int count = Integer.parseInt(args[3]); // Кількість чисел

        // Генерую випадкові числа
        RandomNumberGenerator generator = new RandomNumberGenerator(lowerBound, upperBound, count);
        int[] numbers = generator.generateNumbers();

        // Створюю обробник файлів і виконуємо запис та читання
        FileHandler fileHandler = new FileHandler(fileName);
        fileHandler.writeNumbersToFile(numbers);
        fileHandler.readNumbersFromFile();
    }
}