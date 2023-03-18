package hello.item;


import org.springframework.data.repository.CrudRepository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public interface ItemRepo extends CrudRepository<Item, Long> {
}