

package org.example;

public class Main {
    public static void main(String[] args) {
        // Завдання 1
        int a = 10, b = 20, c = 30, d = 40, e = 50, f = 60, g = 70, h = 80, i = 90, j = 100;
        int sum = a + b + c + d + e + f + g + h + i + j;
        int sub = a - b - c - d - e - f - g - h - i - j;
        int mul = a * b * c * d * e * f * g * h * i * j;
        double div = (double) a / b / c / d / e / f / g / h / i / j;
        System.out.println("Sum: " + sum);
        System.out.println("Subtraction: " + sub);
        System.out.println("Multiplication: " + mul);
        System.out.println("Division: " + div);


        // Завдання 2
        String word1 = "This", word2 = "is", word3 = "a", word4 = "Java", word5 = "program", word6 = "for", word7 = "solving", word8 = "different", word9 = "tasks", word10 = "easily.";
        System.out.println(word1 + " " + word2 + " " + word3 + " " + word4 + " " + word5 + " " + word6 + " " + word7 + " " + word8 + " " + word9 + " " + word10);

        // Завдання 3
        class User {
            int id, age;
            String name, surname;
            double weight, height;
            public User(int id, int age, String name, String surname, double weight, double height) {
                this.id = id;
                this.age = age;
                this.name = name;
                this.surname = surname;
                this.weight = weight;
                this.height = height;
            }
        }
        User[] users = {
                new User(1, 25, "John", "Doe", 70.5, 175.0),
                new User(2, 30, "Jane", "Smith", 65.0, 168.0),
                new User(3, 22, "Alice", "Brown", 55.0, 160.0),
                new User(4, 28, "Bob", "Wilson", 80.0, 180.0),
                new User(5, 35, "Charlie", "Johnson", 90.0, 185.0),
                new User(6, 40, "David", "White", 78.0, 177.0),
                new User(7, 27, "Emma", "Harris", 60.0, 165.0),
                new User(8, 31, "Frank", "Martin", 85.0, 182.0),
                new User(9, 29, "Grace", "Taylor", 58.0, 163.0),
                new User(10, 26, "Hank", "Anderson", 75.0, 172.0)
        };
        int totalAge = 0;
        double totalWeight = 0, totalHeight = 0;
        for (User user : users) {
            totalAge += user.age;
            totalWeight += user.weight;
            totalHeight += user.height;
        }
        System.out.println("Total Age: " + totalAge);
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Total Height: " + totalHeight);

        // Завдання 4
        class Car {
            int horsepower;
            double engineVolume;
            String model, color, fuelType;
            int year, seats;
            boolean automatic;
            public Car(int horsepower, double engineVolume, String model, String color, String fuelType, int year, int seats, boolean automatic) {
                this.horsepower = horsepower;
                this.engineVolume = engineVolume;
                this.model = model;
                this.color = color;
                this.fuelType = fuelType;
                this.year = year;
                this.seats = seats;
                this.automatic = automatic;
            }
        }
        Car[] cars = {
                new Car(150, 2.0, "Toyota", "Red", "Petrol", 2020, 5, true),
                new Car(200, 2.5, "BMW", "Black", "Diesel", 2019, 5, true),
                new Car(120, 1.6, "Honda", "Blue", "Petrol", 2018, 5, false),
                new Car(180, 2.2, "Ford", "White", "Hybrid", 2021, 5, true),
                new Car(250, 3.0, "Audi", "Grey", "Petrol", 2022, 5, true),
                new Car(130, 1.8, "Nissan", "Silver", "Diesel", 2017, 5, false),
                new Car(300, 3.5, "Mercedes", "Black", "Petrol", 2023, 5, true),
                new Car(140, 2.0, "Mazda", "Red", "Hybrid", 2020, 5, false),
                new Car(220, 2.8, "Chevrolet", "Blue", "Petrol", 2016, 5, true),
                new Car(160, 2.0, "Hyundai", "Green", "Diesel", 2015, 5, false)
        };
        int totalHorsepower = 0;
        double totalEngineVolume = 0;
        for (Car car : cars) {
            totalHorsepower += car.horsepower;
            totalEngineVolume += car.engineVolume;
        }
        System.out.println("Total Horsepower: " + totalHorsepower);
        System.out.println("Total Engine Volume: " + totalEngineVolume);

        // Завдання 5
        int number = 412;
        int reversed = number % 400;

        System.out.println("Reversed number: " + reversed);
    }
}


