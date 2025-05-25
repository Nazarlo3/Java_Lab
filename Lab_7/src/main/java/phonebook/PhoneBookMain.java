package phonebook;

public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Іванов", "123456");
        phoneBook.add("Петров", "987654");
        phoneBook.add("Сидоров", "456789");

        phoneBook.printAll();

        System.out.println("Шукаємо номер Іванова: " + phoneBook.get("Іванов"));
        System.out.println("Шукаємо номер Невідомого: " + phoneBook.get("Невідомий"));

        phoneBook.remove("Петров");
        phoneBook.printAll();
    }
}