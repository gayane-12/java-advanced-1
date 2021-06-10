package test;

import test.models.Car;
import test.services.CarService;

public class Test {
    public static void main(String[] args) {
        Car newCar = CarService.create("BMW", 2018, "blue", 200000);
        CarService.serializeToXML(newCar);
        Car decodedCar = CarService.deserializeFromXML();
        CarService.printInfo(decodedCar);
    }
}
