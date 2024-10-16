package vn.edu.iuh.fit.wwwduongtuankietlab04.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<T, ID> {
    private final DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public AbstractDAO(DataSource dataSource){
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public abstract boolean create(T t);
    public abstract List<T> getAll();
    public abstract Optional<T> findById(ID id);
    public abstract boolean update(T t);
    public abstract boolean delete(ID id);

}
