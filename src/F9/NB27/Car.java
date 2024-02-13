package F9.NB27;

import java.io.*;
import java.util.*;

public class Car implements Comparable<Car> {
    private String brand;
    private int year;
    private int miles;

    public Car(String brand, int year, int miles) {
        this.brand = brand;
        this.year = year;
        this.miles = miles;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getMiles() {
        return miles;
    }

    @Override
    public int compareTo(Car another) {
        return this.brand.compareTo(another.brand);
    }

    @Override
    public String toString() {
        return brand;
    }
}


