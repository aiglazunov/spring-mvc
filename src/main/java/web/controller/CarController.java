package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count
                            , ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford Focus", 1, 2000));
        cars.add(new Car("Ford Focus", 2, 2001));
        cars.add(new Car("Ford Focus", 3, 2002));
        cars.add(new Car("Ford Focus", 4, 2003));
        cars.add(new Car("Ford Focus", 5, 2004));
        cars.add(new Car("Ford Focus", 6, 2005));

        if (count == null) count = cars.size();

        List<Car> carsShow;

        if (count >= 5) {
            carsShow = cars;
        }
        else {
            carsShow = cars.subList(0, count);
        }
        model.addAttribute("cars", carsShow);
        return "cars";
    }
}
