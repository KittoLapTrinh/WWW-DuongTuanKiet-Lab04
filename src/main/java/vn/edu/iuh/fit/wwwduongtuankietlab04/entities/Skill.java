package vn.edu.iuh.fit.wwwduongtuankietlab04.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Skill {
    private UUID id;
    private String name;
    private String description;


    private SkillType type;


    public Skill(UUID id) {
        this.id = id;
    }
}
