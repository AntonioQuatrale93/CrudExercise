package it.develhope.CrudExercise.dto;

import it.develhope.CrudExercise.entities.Car;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
@Entity
@Data
public class CarDto extends Car {

    private String type;


}
