package vn.edu.iuh.fit.wwwduongtuankietlab04.dao;

import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.JobSkill;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.JobSkillID;
import vn.edu.iuh.fit.wwwduongtuankietlab04.mapper.JobSkillMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class JobSkillDAO extends AbstractDAO<JobSkill, JobSkillID> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public JobSkillDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(JobSkill jobSkill) {
        String sql = "INSERT job_skill VALUES (?,?,?,?)";

        int updated = jdbcTemplate.update(sql, jobSkill.getMoreInfos(), jobSkill.getSkillLevel().getValue(), jobSkill.getJob().getId(), jobSkill.getSkill().getId());

        return updated > 0;
    }

    @Override
    public List<JobSkill> getAll() {
        String sql = "SELECT * FROM job_skill";

        return jdbcTemplate.query(sql, new JobSkillMapper());
    }

    @Override
    public Optional<JobSkill> findById(JobSkillID jobSkillID) {
        String sql = "SELECT * FROM job_skill WHERE skill_id = ? and job_id = ?";

        try {
            JobSkill jobSkill = jdbcTemplate.queryForObject(sql, new JobSkillMapper(), jobSkillID.getSkill().getId(), jobSkillID.getJob().getId());

            if (jobSkill != null)
                return Optional.of(jobSkill);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public boolean update(JobSkill jobSkill) {
        String sql = "UPDATE job_skill SET more_infos = ?, skill_level = ? WHERE skill_id = ? and job_id = ?";

        int updated = jdbcTemplate.update(sql, jobSkill.getMoreInfos(), jobSkill.getSkillLevel().getValue(), jobSkill.getSkill().getId(), jobSkill.getJob().getId());

        return updated > 0;
    }

    @Override
    public boolean delete(JobSkillID jobSkillID) {
        String sql = "DELETE FROM job_skill WHERE skill_id = ? and job_id = ?";

        int updated = jdbcTemplate.update(sql, jobSkillID.getSkill().getId(), jobSkillID.getJob().getId());

        return updated > 0;
    }
}
