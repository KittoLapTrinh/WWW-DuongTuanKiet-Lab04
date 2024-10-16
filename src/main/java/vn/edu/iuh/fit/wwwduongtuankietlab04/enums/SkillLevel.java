package vn.edu.iuh.fit.wwwduongtuankietlab04.enums;

import lombok.*;

import java.util.Arrays;

@Getter
public enum SkillLevel {
    BEGINNER(1),
    INTERMEDIATE(2),
    PROFICIENT(3),
    ADVANCED(4),
    EXPERT(5);

    private final int value;

    SkillLevel(int i) {
        this.value = i;
    }

    public static SkillLevel convert(int value) {
        return Arrays.stream(SkillLevel.values())
                .filter(skillLevel -> skillLevel.value == value)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);

    }




}
