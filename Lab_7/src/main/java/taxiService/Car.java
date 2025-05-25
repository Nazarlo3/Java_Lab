package taxiService;

class Car {
    private String brand;
    private int enginePower;
    private Driver driver;
    private int price;
    private int year;

    public Car(String brand, int enginePower, Driver driver, int price, int year) {
        this.brand = brand;
        this.enginePower = enginePower;
        this.driver = driver;
        this.price = price;
        this.year = year;
    }

    public void repairEngine() {
        enginePower += enginePower / 10; // +10%
    }

    public void increasePowerAndPrice() {
        enginePower += enginePower / 10; // +10% потужність
        price += price / 20; // +5% ціна
    }

    public void printInfo() {
        System.out.println("Марка: " + brand + ", Потужність: " + enginePower + " к.с., Водій: " + (driver != null ? driver.getName() : "Немає"));
    }

    public String getBrand() {
        return brand;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}