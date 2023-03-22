package hello.item;


import hello.order.Order;
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
import java.util.Date;
import java.util.List;

@Repository
public class ItemRepo {
    @PersistenceContext
    private EntityManager entityManager;
    public JdbcTemplate jdbcTemplate;
    private final RowMapper<Item> itemRowMapper;
    public ItemRepo(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        itemRowMapper = (x, smth) -> {
            Item item = new Item();
            item.setId(x.getLong("id"));
            item.setName(x.getString("name"));
            item.setPrice(x.getLong("price"));
            item.setCreationDate(x.getString("creation_date"));
            Long orderId = x.getLong("order_id");
            if (orderId != null){
                Order order = new Order();
                order.setId(orderId);
                order.setOrderDate(x.getString("order_order_date"));
                item.setOrder(order);
            }
            return item;
        };

    }



    public List<Item> findAll() {
        String sql = "SELECT i.*, o.order_date AS order_order_date " +
                "FROM items i " +
                "LEFT JOIN orders o ON i.order_id = o.id";
        return jdbcTemplate.query(sql, itemRowMapper);
    }

    public Item findById(Long id) {
        String sql =
                "SELECT i.*, o.order_date AS order_order_date " +
                        "FROM items i " +
                        "LEFT JOIN orders o ON i.order_id = o.id " +
                        "WHERE i.id = ?";

        return jdbcTemplate.query(sql, itemRowMapper, id).get(0);
    }

    public void save(Item item) {
        String sql =
                "INSERT INTO items (name, creation_date, price, order_id) VALUES (?, ?, ?, ?)";
        System.out.println(item.getPrice());
        jdbcTemplate.update(
                sql,
                item.getName(),
                item.getCreationDate(),
                item.getPrice(),
                item.getOrder().getId()
        );

    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM items WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    public List<Item> filter(String name, String date, Double price){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
        Root<Item> itemRoot = criteriaQuery.from(Item.class);
        Predicate predicate = criteriaBuilder.conjunction();
        if (name!= null && !name.isEmpty()){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(itemRoot.get("name"), name));
        }
        if (date != null){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(itemRoot.get("creation_date"), date));
        }
        if (price != null){
           predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(itemRoot.get("price"), price));
        }

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
