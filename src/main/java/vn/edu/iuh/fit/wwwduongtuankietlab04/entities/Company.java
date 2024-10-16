package vn.edu.iuh.fit.wwwduongtuankietlab04.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {

    private UUID compId;
    private String webUrl;
    private String name;
    private String email;
    private String phone;
    private String about;
    private Address address;

    public Company(UUID compId) {
        this.compId = compId;
    }
}
