package it.develhope.CrudExercise.services;

import it.develhope.CrudExercise.dto.CarDto;
import it.develhope.CrudExercise.entities.Car;
import it.develhope.CrudExercise.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car create(Car car){
        return carRepository.save(car);
    }

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    public Optional<Car> getById(long id){
        if(carRepository.existsById(id)){
            Optional<Car> founded = carRepository.findById(id);
            return founded;

        }else{
            Car car = new Car();
            return Optional.of(car);
        }
    }

    public Car update(Long id, CarDto carDto) {
        if(carRepository.existsById(id)){
        Car car = carRepository.getReferenceById(id);
        car.setModelName(car.getModelName());
        car.setType(carDto.getType());
       Car newCar = carRepository.saveAndFlush(car);
        return newCar;
    }else{
            return new Car();
        }
    }

    public ResponseEntity delete(long id) {
        if(carRepository.existsById(id)){
            carRepository.deleteById(id);
            return null;
        }else{
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    public void deleteAll(){
        carRepository.deleteAll();
    }

}
