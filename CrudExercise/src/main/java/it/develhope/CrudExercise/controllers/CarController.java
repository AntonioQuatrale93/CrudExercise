package it.develhope.CrudExercise.controllers;

import it.develhope.CrudExercise.dto.CarDto;
import it.develhope.CrudExercise.entities.Car;
import it.develhope.CrudExercise.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public Car createCar(@RequestBody Car car){
        return carService.create(car);
    }

    @GetMapping
    public List<Car> getAllCar(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getById(@PathVariable long id){
        return carService.getById(id);
    }

    @PutMapping("")
    public Car updateCar(@RequestParam Long id, @RequestBody CarDto carDto){
        return carService.update(id , carDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable @Valid long id){
        return carService.delete(id);
    }

    @DeleteMapping
    public void deleteAllCar(){
        carService.deleteAll();
    }

}
