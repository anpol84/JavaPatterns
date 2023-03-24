package hello.order;

import hello.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.mail.MessagingException;
import java.util.List;

@Service
@Slf4j
@Transactional
public class OrderService {

    private OrderRepo orderRepo;
    private MyOrderRepo myOrderRepo;
    private EmailService emailService;
    public OrderService() {
    }
    @Autowired
    public OrderService(OrderRepo orderRepo, MyOrderRepo myOrderRepo, EmailService emailService){
        this.orderRepo = orderRepo;
        this.myOrderRepo = myOrderRepo;
        this.emailService = emailService;
    }

    public void save(Order order){
        log.info("saving order {}", order);
        orderRepo.save(order);
        try {
            emailService.sendEmail( "Order saved", "Object: " + order);
        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }

    public List<Order> findAll(){
        log.info("finding all orders");
        return orderRepo.findAll();
    }

    public void deleteById(Long id){
        log.info("deleting order by id {}", id);
        orderRepo.deleteById(id);
    }
    public Order findById(Long id) {
        log.info("finding order by id {}", id);
        return myOrderRepo.findById(id);
    }
    public List<Order> filter(String date){
        log.info("filtering order");
        return myOrderRepo.filter(date);
    }
}
