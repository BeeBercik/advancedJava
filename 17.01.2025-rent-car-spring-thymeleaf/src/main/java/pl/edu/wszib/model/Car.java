package pl.edu.wszib.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    private String model;
    private String name;
    private int year;
}
