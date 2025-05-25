package org.example;

// Завдання 1: Клас Person
class Person {
    private String fullName;
    private int age;

    public Person() {
        this.fullName = "Невідомий";
        this.age = 0;
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public void move() {
        System.out.println(fullName + " рухається.");
    }

    public void talk() {
        System.out.println(fullName + " говорить.");
    }
}

// Завдання 2: Клас Phone
class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this(number, model, 0.0);
    }

    public Phone() {
        this("Невідомий номер", "Невідома модель", 0.0);
    }

    public void receiveCall(String callerName) {
        System.out.println("Дзвонить " + callerName);
    }

    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("Дзвонить " + callerName + " (" + callerNumber + ")");
    }

    public String getNumber() {
        return number;
    }

    public void sendMessage(String... numbers) {
        System.out.println("Надсилаємо повідомлення на номери:");
        for (String num : numbers) {
            System.out.println(num);
        }
    }
}

// Завдання 3: Ієрархія
class LivingBeing {
    public void exist() {
        System.out.println("Живий організм існує.");
    }
}

class Human extends LivingBeing {
    public void think() {
        System.out.println("Людина думає.");
    }
}

class Worker extends Human {
    public void work() {
        System.out.println("Працівник працює.");
    }
}

// Завдання 4: Клас Car з Builder
abstract class Car {
    protected String model;
    protected String color;
    protected int maxSpeed;

    protected Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void gas() {
        System.out.println("Газуємо!");
    }

    public abstract void brake();

    public static abstract class Builder<T extends Builder<T>> {
        protected String model = "Невідома модель";
        protected String color = "Сірий";
        protected int maxSpeed = 100;

        public T model(String model) {
            this.model = model;
            return self();
        }

        public T color(String color) {
            this.color = color;
            return self();
        }

        public T maxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return self();
        }

        protected abstract T self();
        public abstract Car build();
    }
}

class Sedan extends Car {
    private Sedan(String model, String color, int maxSpeed) {
        super(model, color, maxSpeed);
    }

    @Override
    public void brake() {
        System.out.println("Седан гальмує плавно.");
    }

    public static class Builder extends Car.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Sedan build() {
            return new Sedan(model, color, maxSpeed);
        }
    }
}

class Truck extends Car {
    private Truck(String model, String color, int maxSpeed) {
        super(model, color, maxSpeed);
    }

    @Override
    public void brake() {
        System.out.println("Вантажівка гальмує повільно.");
    }

    public static class Builder extends Car.Builder<Builder> {
        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Truck build() {
            return new Truck(model, color, maxSpeed);
        }
    }
}

// Завдання 5.6: Клас LibraryCard
class LibraryCard {
    protected String name;
    protected String surname;
    protected int booksBorrowed;

    public LibraryCard(String name, String surname, int booksBorrowed) {
        this.name = name;
        this.surname = surname;
        this.booksBorrowed = booksBorrowed;
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public void returnBook() {
        if (booksBorrowed > 0) booksBorrowed--;
    }

    public void displayInfo() {
        System.out.println("Картка читача: " + name + " " + surname + ", книг взято: " + booksBorrowed);
    }
}

// Завдання 6: Розширений клас LibraryCardPlus
class LibraryCardPlus extends LibraryCard {
    private String libraryName;
    private boolean isActive;

    public LibraryCardPlus(String name, String surname, int booksBorrowed, String libraryName, boolean isActive) {
        super(name, surname, booksBorrowed);
        this.libraryName = libraryName;
        this.isActive = isActive;
    }

    @Override
    public void displayInfo() {
        System.out.println("Картка читача: " + name + " " + surname + ", бібліотека: " + libraryName + ", активна: " + (isActive ? "Так" : "Ні") + ", книг взято: " + booksBorrowed);
    }
}

// Головний клас із методом main
public class Mainik {
    public static void main(String[] args) {
        // Завдання 1: Перевірка класу Person
        System.out.println("=== Завдання 1: Перевірка класу Person ===");
        Person person1 = new Person();
        Person person2 = new Person("Іван Іванов", 30);
        person1.move();
        person2.talk();

        // Завдання 2: Перевірка класу Phone
        System.out.println("\n=== Завдання 2: Перевірка класу Phone ===");
        Phone phone1 = new Phone("123456789", "Model1", 150.5);
        Phone phone2 = new Phone("987654321", "Model2");
        Phone phone3 = new Phone();

        System.out.println(phone1.getNumber());
        System.out.println(phone2.getNumber());
        System.out.println(phone3.getNumber());

        phone1.receiveCall("Олег");
        phone2.receiveCall("Марія", "987654321");
        phone1.sendMessage("123456789", "987654321", "555555555");

        // Завдання 3: Ієрархія
        System.out.println("\n=== Завдання 3: Перевірка ієрархії ===");
        Worker worker = new Worker();
        worker.exist();
        worker.think();
        worker.work();

        // Завдання 4: Перевірка класу Car з Builder
        System.out.println("\n=== Завдання 4: Перевірка класу Car з Builder ===");
        Car sedan = new Sedan.Builder()
                .model("Toyota Camry")
                .color("Червоний")
                .maxSpeed(210)
                .build();

        Car truck = new Truck.Builder()
                .model("Volvo FH")
                .color("Синій")
                .build();

        sedan.gas();
        sedan.brake();

        truck.gas();
        truck.brake();

        // Завдання 5.6: Перевірка класів LibraryCard та LibraryCardPlus
        System.out.println("\n=== Завдання 5.6: Перевірка класів LibraryCard та LibraryCardPlus ===");
        LibraryCard card = new LibraryCard("Ольга", "Петренко", 3);
        LibraryCardPlus cardPlus = new LibraryCardPlus("Ольга", "Петренко", 3, "Центральна бібліотека", true);

        card.displayInfo();
        cardPlus.displayInfo();
    }
}
