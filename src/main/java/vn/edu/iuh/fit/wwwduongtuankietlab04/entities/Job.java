package vn.edu.iuh.fit.wwwduongtuankietlab04.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Job {
    private UUID id;
    private String name;
    private String desc;
    private Company company;

    public Job(UUID id) {
        this.id = id;
    }
}
