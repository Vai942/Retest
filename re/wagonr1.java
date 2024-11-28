package com.re;

import java.util.Scanner;
import java.io.*;
 
// Abstract class Car
abstract class Car {
    protected boolean isSedan;
    protected String seats;

    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }
    public boolean getIsSedan() {
        return this.isSedan;
    }
    public String getSeats() {
        return this.seats;
    }
    abstract public String getMileage();
    public void printCar(String name) {
        System.out.println( 
          "A " + name + " is " + (this.getIsSedan() ? "" : "not ") 
            + "Sedan, is " + this.getSeats() + "-seater, and has a mileage of around "
            + this.getMileage() + ".");
    }
}
 
// WagonR class that extends Car
class WagonR extends Car {
    private int mileage;
    public WagonR(int mileage) {
        super(false, "5");  // WagonR is not a Sedan, and typically 5-seater
        this.mileage = mileage;
    }
    @Override
    public String getMileage() {
        return mileage + " kmpl";
    }
}
 
// HondaCity class that extends Car
class HondaCity extends Car {
    private int mileage;
    public HondaCity(int mileage) {
        super(true, "5");  // HondaCity is a Sedan, and typically 5-seater
        this.mileage = mileage;
    }
    @Override
    public String getMileage() {
        return mileage + " kmpl";
    }
}
 
// InnovaCrysta class that extends Car
class InnovaCrysta extends Car {
    private int mileage;
    public InnovaCrysta(int mileage) {
        super(false, "7");  // InnovaCrysta is not a Sedan, and typically 7-seater
        this.mileage = mileage;
    }
    @Override
    public String getMileage() {
        return mileage + " kmpl";
    }
}
 
public class wagonr1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int carType = Integer.parseInt(bufferedReader.readLine().trim());
        int carMileage = Integer.parseInt(bufferedReader.readLine().trim());
        if (carType == 0) {
            Car wagonR = new WagonR(carMileage);
            wagonR.printCar("WagonR");
        } else if (carType == 1) {
            Car hondaCity = new HondaCity(carMileage);
            hondaCity.printCar("HondaCity");
        } else if (carType == 2) {
            Car innovaCrysta = new InnovaCrysta(carMileage);
            innovaCrysta.printCar("InnovaCrysta");
        }
    }
}
