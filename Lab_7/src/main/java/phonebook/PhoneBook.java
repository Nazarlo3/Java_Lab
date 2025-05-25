package phonebook;

class PhoneBook {
    private String[] names = new String[10];
    private String[] numbers = new String[10];
    private int size = 0;

    public void add(String name, String number) {
        if (size < names.length) {
            names[size] = name;
            numbers[size] = number;
            size++;
        }
    }

    public String get(String name) {
        for (int i = 0; i < size; i++) {
            if (names[i].equals(name)) {
                return numbers[i];
            }
        }
        return "У книзі відсутній такий абонент";
    }

    public void remove(String name) {
        for (int i = 0; i < size; i++) {
            if (names[i].equals(name)) {
                names[i] = names[size - 1];
                numbers[i] = numbers[size - 1];
                size--;
                return;
            }
        }
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(names[i] + " -> " + numbers[i]);
        }
    }
}