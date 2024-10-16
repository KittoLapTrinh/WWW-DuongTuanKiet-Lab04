package vn.edu.iuh.fit.wwwduongtuankietlab04.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

    private UUID id;
    private String city;
    private String street;
    private Short country;
    private String number;
    private String zipcode;

    public Address(UUID id) {
        this.id = id;
    }
}
