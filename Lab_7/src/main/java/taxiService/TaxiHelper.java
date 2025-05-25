package taxiService;

import java.util.Random;

class TaxiHelper {
    private final Car[] cars;
    private final Random random;

    public TaxiHelper(Car[] cars) {
        this.cars = cars;
        this.random = new Random();
    }

    public void findRandomCar() {
        int index = random.nextInt(cars.length);
        System.out.println("Автомобіль марки " + cars[index].getBrand() + " з водієм " + cars[index].getDriver().getName() + " виїхав за вами");
        carArrived(cars[index]);
    }

    private void carArrived(Car car) {
        System.out.println("Водій " + car.getDriver().getName() + " прибув на місце");
    }
}