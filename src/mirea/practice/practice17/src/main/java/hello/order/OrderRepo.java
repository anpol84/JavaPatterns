package hello.order;

import hello.item.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderRepo{
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Item> itemRowMapper;
    private final RowMapper<Order> orderRowMapper;
    @PersistenceContext
    private EntityManager entityManager;
    public OrderRepo(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        orderRowMapper = new BeanPropertyRowMapper<>(Order.class);
        itemRowMapper = new BeanPropertyRowMapper<>(Item.class);
    }

    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        List<Order> orders = jdbcTemplate.query(sql, orderRowMapper);
        for (Order item : orders){
            item.setItems(getItemByOrderId(item.getId()));
        }
        return orders;
    }
    public Order findById(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        Order order = jdbcTemplate.query(sql, orderRowMapper, id).get(0);

        order.setItems(getItemByOrderId(id));
        return order;
    }

    private List<Item> getItemByOrderId(Long id) {
        String sql =
                "SELECT i.name, i.creation_date, i.price, i.id FROM items i " +
                        "WHERE i.order_id = ?";

        return jdbcTemplate.query(sql, itemRowMapper, id);
    }

    public void save(Order order) {
        String sql =
                "INSERT INTO orders (order_date) VALUES (?)";
        jdbcTemplate.update(
                sql,
                order.getOrderDate()
        );
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    public List<Order> filter(String date){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = builder.createQuery(Order.class);
        Root<Order> orderRoot = criteriaQuery.from(Order.class);

        Predicate predicate = builder.conjunction();

        if (date != null) {
            predicate = builder.and(predicate, builder.like(orderRoot.get("orderDate"), date));
        }




        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
