package vn.edu.iuh.fit.wwwduongtuankietlab04.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.edu.iuh.fit.wwwduongtuankietlab04.dao.CandidateSkillDAO;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Candidate;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.CandidateSkill;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Skill;
import vn.edu.iuh.fit.wwwduongtuankietlab04.enums.SkillLevel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CandidateSkillMapper implements RowMapper<CandidateSkill> {
    @Override
    public CandidateSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
        String canId = rs.getString("can_id");
        String skillId = rs.getString("skill_id");
        String moreInfos = rs.getString("more_infos");
        int skillLevelInt = rs.getInt("skill_level");

        Candidate candidate = new Candidate(UUID.fromString(canId));
        Skill skill = new Skill(UUID.fromString(skillId));
        SkillLevel skillLevel = SkillLevel.convert(skillLevelInt);

        return new CandidateSkill(candidate,skill, moreInfos, skillLevel);
    }
}
