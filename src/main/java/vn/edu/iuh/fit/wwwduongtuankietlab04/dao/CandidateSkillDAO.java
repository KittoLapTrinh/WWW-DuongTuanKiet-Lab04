package vn.edu.iuh.fit.wwwduongtuankietlab04.dao;

import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.CandidateSkill;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.CandidateSkillID;
import vn.edu.iuh.fit.wwwduongtuankietlab04.mapper.CandidateSkillMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class CandidateSkillDAO extends AbstractDAO<CandidateSkill, CandidateSkillID> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CandidateSkillDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(CandidateSkill candidateSkill) {
        String sql = "INSERT candidate_skill VALUES (?,?,?,?)";

        int updated = jdbcTemplate.update(sql, candidateSkill.getMoreInfos(), candidateSkill.getSkillLevel().getValue(), candidateSkill.getSkill().getId(), candidateSkill.getCandidate().getId());

        return updated > 0;
    }

    @Override
    public List<CandidateSkill> getAll() {
        String sql  = "SELECT * FROM candidate_skill";

        return jdbcTemplate.query(sql, new CandidateSkillMapper());
    }

    @Override
    public Optional<CandidateSkill> findById(CandidateSkillID candidateSkillID) {
        String sql = "SELECT * FROM candidate_skill WHERE skill_id = ? and can_id = ?";

        try {
            CandidateSkill candidateSkill = jdbcTemplate.queryForObject(sql, new CandidateSkillMapper(), candidateSkillID.getSkill().getId(), candidateSkillID.getCandidate().getId());

            if (candidateSkill != null)
                return Optional.of(candidateSkill);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public boolean update(CandidateSkill candidateSkill) {
        String sql = "UPDATE candidate_skill SET more_infos = ?, skill_level = ? WHERE skill_id = ? and can_id = ?";

        int updated = jdbcTemplate.update(sql, candidateSkill.getMoreInfos(), candidateSkill.getSkillLevel().getValue(), candidateSkill.getSkill().getId(), candidateSkill.getCandidate().getId());

        return updated > 0;
    }

    @Override
    public boolean delete(CandidateSkillID candidateSkillID) {
        String sql = "DELETE FROM candidate_skill WHERE skill_id = ? and can_id = ?";

        int updated = jdbcTemplate.update(sql, candidateSkillID.getSkill().getId(), candidateSkillID.getCandidate().getId());

        return updated > 0;
    }
}
