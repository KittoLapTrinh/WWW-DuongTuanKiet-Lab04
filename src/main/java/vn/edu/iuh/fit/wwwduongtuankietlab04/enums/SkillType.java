package vn.edu.iuh.fit.wwwduongtuankietlab04.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum SkillType {
    HARD(1),
    SOFT(2),
    TECHNICAL(3),
    MANAGERIAL(4),
    CREATIVE(5);

    private final int value;

    SkillType(int i) {
        this.value = i;
    }

    public static SkillType convert(int value){
        return Stream.of(SkillType.values())
                .filter(skill -> skill.value == value)
                .findFirst().orElseThrow(IllegalAccessError::new);
    }


}
