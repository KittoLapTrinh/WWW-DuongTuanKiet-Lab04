package vn.edu.iuh.fit.wwwduongtuankietlab04.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Candidate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CandidateDAO extends AbstractDAO<Candidate, UUID>{
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    public CandidateDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(Candidate candidate) {
        String sql = "INSERT INTO VALUES (?, ?, ? , ?, ? ,?)";
        int intered = jdbcTemplate.update(sql, candidate.getId(), candidate.getAddress(), candidate.getDob(), candidate.getEmail(), candidate.getPhone(), candidate.getFullName());
        return intered > 0;
    }

    @Override
    public List<Candidate> getAll() {
        String sql = "SELECT * FROM candidate";
        return jdbcTemplate.query(sql , new BeanPropertyRowMapper<>(Candidate.class));
    }

    @Override
    public Optional<Candidate> findById(UUID uuid) {
        String sql = "SELECT * FROM candidate where id = ?";
        try{
            Candidate candidate = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Candidate.class), uuid);
            assert candidate != null;
            return Optional.of(candidate);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public boolean update(Candidate candidate) {
        String sql = "Update Candidate set dob = ?, full_name";
        int update = jdbcTemplate.update(sql, candidate.getPhone(), candidate.getFullName(), candidate.getAddress(), candidate.getPhone(), candidate.getAddress());
        return update > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM candidate where id = ?";
        int update = jdbcTemplate.update(sql,uuid);
        return update > 0;
    }
}
