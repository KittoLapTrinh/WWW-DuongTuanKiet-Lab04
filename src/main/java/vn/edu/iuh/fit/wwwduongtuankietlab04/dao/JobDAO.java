package vn.edu.iuh.fit.wwwduongtuankietlab04.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.sql.DataSource;

import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Job;
import vn.edu.iuh.fit.wwwduongtuankietlab04.mapper.JobMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class JobDAO extends AbstractDAO<Job, UUID> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public JobDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(Job job) {
        String sql = "INSERT job VALUES (?,?,?,?)";

        int updated = jdbcTemplate.update(sql, job.getId(), job.getDesc(), job.getName(), job.getCompany().getCompId());

        return updated > 0;
    }

    @Override
    public List<Job> getAll() {
        String sql  = "SELECT * FROM job";

        return jdbcTemplate.query(sql, new JobMapper());
    }

    @Override
    public Optional<Job> findById(UUID uuid) {
        String sql = "SELECT * FROM JOB WHERE job_id = ?";

        try {
            Job job = jdbcTemplate.queryForObject(sql, new JobMapper(), uuid);

            if (job != null)
                return Optional.of(job);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public boolean update(Job job) {
        String sql = "UPDATE JOB SET job_desc = ?, job_name = ?, company = ? WHERE job_id = ?";

        int updated = jdbcTemplate.update(sql, job.getDesc(), job.getName(), job.getCompany().getCompId(), job.getId());

        return updated > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM job WHERE job_id = ?";

        int updated = jdbcTemplate.update(sql, uuid);

        return updated > 0;
    }
}
