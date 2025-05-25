package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Розв’язок квадратного рівняння ax^2 + bx + c = 0
        System.out.println("Введіть коефіцієнти a, b, c для квадратного рівняння:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корені рівняння: x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Рівняння має один корінь: x = " + x);
        } else {
            System.out.println("Рівняння не має дійсних коренів.");
        }

        // 2. Визначення квадранта точки (x, y)
        System.out.println("Введіть координати точки (x, y):");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        if (x > 0 && y > 0) {
            System.out.println("Точка знаходиться в I квадранті.");
        } else if (x < 0 && y > 0) {
            System.out.println("Точка знаходиться в II квадранті.");
        } else if (x < 0 && y < 0) {
            System.out.println("Точка знаходиться в III квадранті.");
        } else if (x > 0 && y < 0) {
            System.out.println("Точка знаходиться в IV квадранті.");
        } else {
            System.out.println("Точка знаходиться на осі координат.");
        }

        // 3. Перевірка двозначного парного числа
        System.out.println("Введіть число для перевірки:");
        int num = scanner.nextInt();
        if (num >= 10 && num <= 99 && num % 2 == 0) {
            System.out.println("Число " + num + " є двозначним і парним.");
        } else {
            System.out.println("Число " + num + " не відповідає обом критеріям.");
        }

        // 4. Обчислення функції f(x)
        System.out.println("Введіть x для обчислення f(x):");
        double inputX = scanner.nextDouble();
        double result;
        if (inputX < 0) {
            result = Math.pow(Math.sin(inputX), 3) - Math.pow(Math.cos(inputX), 3) + 1;
        } else if (inputX >= 0 && inputX <= 2) {
            result = Math.log(inputX + 2);
        } else {
            result = Math.sqrt(inputX * inputX - Math.pow(inputX, 3));
        }
        System.out.println("f(" + inputX + ") = " + result);
    }
}
