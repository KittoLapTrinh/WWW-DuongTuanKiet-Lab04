package vn.edu.iuh.fit.wwwduongtuankietlab04.dao;

import vn.edu.iuh.fit.wwwduongtuankietlab04.entities.Skill;
import vn.edu.iuh.fit.wwwduongtuankietlab04.mapper.SkillMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SkillDAO extends AbstractDAO<Skill, UUID> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public SkillDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean create(Skill skill) {
        String sql = "INSERT skill VALUES (?,?,?,?)";

        int updated = jdbcTemplate.update(sql, skill.getId(), skill.getDescription(), skill.getName(), skill.getType().getValue());

        return updated > 0;
    }

    @Override
    public List<Skill> getAll() {
        String sql  = "SELECT * FROM skill";

        return jdbcTemplate.query(sql, new SkillMapper());
    }

    @Override
    public Optional<Skill> findById(UUID uuid) {
        String sql = "SELECT * FROM skill WHERE skill_id = ?";

        try {
            Skill skill = jdbcTemplate.queryForObject(sql, new SkillMapper(), uuid);

            if (skill != null)
                return Optional.of(skill);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public boolean update(Skill skill) {
        String sql = "UPDATE skill SET skill_description = ?, skill_name = ?, type = ? WHERE skill_id = ?";

        int updated = jdbcTemplate.update(sql, skill.getDescription(), skill.getName(), skill.getType().getValue(), skill.getId());

        return updated > 0;
    }

    @Override
    public boolean delete(UUID uuid) {
        String sql = "DELETE FROM skill WHERE skill_id = ?";

        int updated = jdbcTemplate.update(sql, uuid);

        return updated > 0;
    }
}
