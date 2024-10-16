package vn.edu.iuh.fit.wwwduongtuankietlab04.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Candidate {
    private UUID id;
    private LocalDate dob;
    private String fullName;
    private String email;
    private String phone;
    private Address address;

    public Candidate(UUID id) {
        this.id = id;
    }
}
