package hello.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderRepo{
    public JdbcTemplate jdbcTemplate;

    public OrderRepo(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Order.class)
        );
    }

    public void save(Order order) {
        String sql =
                "INSERT INTO orders (name, address) VALUES (?, ?)";
        jdbcTemplate.update(
                sql,
                order.getOrderDate()
        );
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
