package it.develhope.CrudExercise.entities;

import lombok.Data;
import org.apache.el.stream.Optional;

import javax.persistence.*;

@Entity
@Data
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String modelName;
    private String type;
}
