package vn.edu.iuh.fit.wwwduongtuankietlab04.entities;

import lombok.*;
import vn.edu.iuh.fit.wwwduongtuankietlab04.enums.SkillLevel;

//@Entity
//@Table(name = "candidate_skill")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CandidateSkill {

    private Candidate candidate;
    private Skill skill;
    private String moreInfos;
    private SkillLevel skillLevel;

    public CandidateSkill(Candidate candidate, Skill skill, String moreInfos, SkillLevel skillLevel) {
        this.candidate = candidate;
        this.skill = skill;
        this.moreInfos = moreInfos;
        this.skillLevel = skillLevel;
    }
}
