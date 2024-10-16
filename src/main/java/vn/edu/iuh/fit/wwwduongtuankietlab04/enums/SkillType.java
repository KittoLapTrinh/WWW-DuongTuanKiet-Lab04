package vn.edu.iuh.fit.wwwduongtuankietlab04.enums;

import lombok.Getter;

@Getter
public enum Skill {
    HARD(1),
    SOFT(2),
    TECHNICAL(3),
    MANAGERIAL(4),
    CREATIVE(5);

    private final int value;

    Skill(int value) {
        this.value = value;
    }

    
}
