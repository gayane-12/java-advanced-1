package test.services;

import test.models.Car;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class CarService {
    private static final String SERIALIZED_FILE_NAME = "src" + File.separator + "files" + File.separator + "car.xml";

    public static Car create(String model, int year, String color, int price) {
        Car newCar = new Car();
        newCar.setModel(model);
        newCar.setYear(year);
        newCar.setColor(color);
        newCar.setPrice(price);
        return newCar;
    }

    public static void printInfo(Car car) {
        System.out.println(car);
    }

    public static void serializeToXML(Car object) {
        try {
            FileOutputStream fos = new FileOutputStream(SERIALIZED_FILE_NAME);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(object);
            encoder.close();
            fos.close();
            System.out.println("Data was serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car deserializeFromXML() {
        Car decodedCar = null;
        try {
            FileInputStream fis = new FileInputStream(SERIALIZED_FILE_NAME);
            XMLDecoder decoder = new XMLDecoder(fis);
            decodedCar = (Car) decoder.readObject();
            decoder.close();
            fis.close();
            System.out.println("Data was deserialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decodedCar;
    }

}
