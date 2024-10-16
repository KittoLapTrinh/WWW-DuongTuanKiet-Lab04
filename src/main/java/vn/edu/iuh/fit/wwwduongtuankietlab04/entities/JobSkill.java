package vn.edu.iuh.fit.wwwduongtuankietlab04.entities;

import lombok.*;
import vn.edu.iuh.fit.wwwduongtuankietlab04.enums.SkillLevel;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobSkill {
    private Skill skill;
    private Job job;
    private String moreInfos;
    private SkillLevel skillLevel;

    public JobSkill(String moreInfos, SkillLevel skillLevel, Job job, Skill skill) {
        this.moreInfos = moreInfos;
        this.skillLevel = skillLevel;
        this.job = job;
        this.skill = skill;

    }


}
