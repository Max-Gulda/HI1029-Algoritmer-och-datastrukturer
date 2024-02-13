package F9.NB27;
import F9.NB27.Car;

import java.io.*;
import java.util.*;

public class CarSorter {
    public static void main(String[] args) throws FileNotFoundException {
        List<Car> cars = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/F9/NB27/cars.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                cars.add(new Car(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            }
        }

        sort(cars);

        try (PrintWriter out = new PrintWriter("src/F9/NB27/sortedByBrand.txt")) {
            for (Car car : cars) {
                out.println(car);
            }
        }

        sortComp(cars, new CompareCar());

        try (PrintWriter out = new PrintWriter("src/F9/NB27/sortedByYear.txt")) {
            for (Car car : cars) {
                out.println(car);
            }
        }
    }

    public static void sortComp(List<Car> cars, Comparator<Car> comp) {
        for(int i = 1; i < cars.size(); i++){
            int dataIndex = i - 1;
            Car car = cars.get(i);
            while(dataIndex >= 0 && comp.compare(cars.get(dataIndex), car) > 0){
                cars.set(dataIndex+1, cars.get(dataIndex));
                dataIndex--;
            }
            cars.set(dataIndex + 1, car);
        }
    }

    public static void sort(List<Car> cars) {
        for(int i = 1; i < cars.size(); i++){
            Car car = cars.get(i);
            int dataIndex = i - 1;
            while(dataIndex >= 0 && car.compareTo(cars.get(dataIndex)) < 0){
                cars.set(dataIndex + 1, cars.get(dataIndex));
                dataIndex--;
            }
            cars.set(dataIndex + 1, car);
        }
    }
}