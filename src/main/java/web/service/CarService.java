package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.*;
@Service
public class CarService {

    private final int MAX_COUNT = 5;

    private List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("Ford Focus", 1, 2000));
        cars.add(new Car("Ford Focus", 2, 2001));
        cars.add(new Car("Ford Focus", 3, 2002));
        cars.add(new Car("Ford Focus", 4, 2003));
        cars.add(new Car("Ford Focus", 5, 2004));
        cars.add(new Car("Ford Focus", 6, 2005));
    }

    public List<Car> getCars(Integer count) {
        if ((count == null) || count > cars.size()) {
            count = cars.size();
        }
        if (count > MAX_COUNT) {
            return cars;
        }
        else {
            return cars.subList(0, count);
        }
    }
}
