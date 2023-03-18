package hello.item;


import org.springframework.data.repository.CrudRepository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ItemRepo {
    public JdbcTemplate jdbcTemplate;

    public ItemRepo(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Item> findAll() {
        String sql = "SELECT * FROM items";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Item.class)
        );
    }

    public void save(Item item) {
        String sql =
                "INSERT INTO items (name, address) VALUES (?, ?)";
        jdbcTemplate.update(
                sql,
                item.getName(),
                item.getCreationDate(),
                item.getPrice()
        );
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM items WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
