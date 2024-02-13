package F9.NB27;

import java.util.Comparator;
import F9.NB27.Car;
class CompareCar implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getYear(), car2.getYear());
    }
}