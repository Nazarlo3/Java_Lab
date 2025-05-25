package taxiService;

public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[10];

        cars[0] = new Car("Toyota", 150, new Driver("Назар", 30, 6), 10000, 2018);
        cars[1] = new Car("Honda", 130, new Driver("Олег", 28, 3), 9000, 2017);
        cars[2] = new Car("Ford", 170, new Driver("Олександр", 35, 8), 12000, 2020);
        cars[3] = new Car("BMW", 200, new Driver("Андрій", 40, 15), 25000, 2022);
        cars[4] = new Car("Nissan", 140, new Driver("Олексій", 27, 2), 9500, 2019);
        cars[5] = new Car("Audi", 190, new Driver("Юрій", 33, 9), 23000, 2021);
        cars[6] = new Car("Hyundai", 160, new Driver("Василь", 29, 4), 11000, 2019);
        cars[7] = new Car("Mercedes", 210, new Driver("Володимир", 45, 20), 27000, 2023);
        cars[8] = new Car("Mazda", 145, new Driver("Іван", 31, 6), 10500, 2018);
        cars[9] = new Car("Kia", 135, new Driver("Петро", 26, 1), 8800, 2017);

        // Половині автопарку робимо ремонт
        for (int i = 0; i < cars.length / 2; i++) {
            cars[i].repairEngine();
            cars[i].setDriver(new Driver("Новий водій " + (i + 1), 30, 5));
        }

        // Кожна друга машина отримує підвищення
        for (int i = 0; i < cars.length; i += 2) {
            cars[i].increasePowerAndPrice();
        }

        // Підвищення кваліфікації водіїв
        for (Car car : cars) {
            if (car.getDriver().getExperience() < 5 && car.getDriver().getAge() > 25) {
                car.getDriver().improveExperience();
            }
        }

        // Викликаємо машину
        TaxiHelper taxiHelper = new TaxiHelper(cars);
        taxiHelper.findRandomCar();
    }
}