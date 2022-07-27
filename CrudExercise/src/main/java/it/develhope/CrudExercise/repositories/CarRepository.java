package it.develhope.CrudExercise.repositories;

import it.develhope.CrudExercise.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>  {






}
