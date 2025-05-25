package org.example;

// ===== ІНТЕРФЕЙС для телефону =====
interface PhoneInterface {
    void receiveCall(String callerName);  // метод для прийому дзвінка
    String getNumber(String number);      // метод для отримання номеру телефону
    String getModel(String model);        // метод для отримання моделі телефону
}

// ===== Клас Phone, який реалізує інтерфейс =====
class Phone implements PhoneInterface {

    // Реалізація методу для прийому дзвінка
    @Override
    public void receiveCall(String callerName) {
        System.out.println("Дзвонить " + callerName);  // виводимо ім'я того, хто дзвонить
    }

    // Реалізація методу для отримання номеру телефону
    @Override
    public String getNumber(String number) {
        return number;
    }

    // Реалізація методу для отримання моделі телефону
    @Override
    public String getModel(String model) {
        return model;
    }
}

// ===== ІНТЕРФЕЙС для картки =====
interface Card {
    void displayInfo();  // метод для виведення інформації
}

// ===== Базова реалізація картки =====
class BasicLibraryCard implements Card {
    protected String name;

    // Конструктор для ініціалізації картки
    public BasicLibraryCard(String name) {
        this.name = name;
    }

    // Реалізація методу для виведення інформації
    @Override
    public void displayInfo() {
        System.out.println("Читач: " + name);
    }
}

// ===== Абстрактний декоратор для картки =====
abstract class LibraryCardDecorator implements Card {
    protected Card decoratedCard;

    // Конструктор для ініціалізації декоратора
    public LibraryCardDecorator(Card decoratedCard) {
        this.decoratedCard = decoratedCard;
    }

    // Делегуємо виклик методу декорованому об'єкту
    @Override
    public void displayInfo() {
        decoratedCard.displayInfo();
    }
}

// ===== Декоратор, який додає назву бібліотеки =====
class LibraryNameDecorator extends LibraryCardDecorator {
    private String libraryName;

    public LibraryNameDecorator(Card card, String libraryName) {
        super(card);
        this.libraryName = libraryName;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Бібліотека: " + libraryName);
    }
}

// ===== Головний клас =====
public class Mainik {
    public static void main(String[] args) {
        // --- Використання інтерфейсу PhoneInterface ---
        PhoneInterface myPhone = new Phone();
        myPhone.receiveCall("Іван");
        System.out.println("Номер телефону: " + myPhone.getNumber("0671234567"));
        System.out.println("Модель телефону: " + myPhone.getModel("Samsung Galaxy S21"));

        // --- Перевірка декоратора ---
        System.out.println("\n=== Перевірка декоратора ===");
        Card card = new BasicLibraryCard("Назар Головацький");
        card = new LibraryNameDecorator(card, "Центральна бібліотека");
        card.displayInfo();
    }
}
