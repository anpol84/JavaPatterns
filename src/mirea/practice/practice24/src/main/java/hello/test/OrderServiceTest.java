package hello.test;

import hello.EmailService;
import hello.order.MyOrderRepo;
import hello.order.Order;
import hello.order.OrderRepo;
import hello.order.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.mail.MessagingException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepo orderRepo;

    @Mock
    private MyOrderRepo myOrderRepo;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_shouldSaveOrderAndSendEmail() throws MessagingException {
        Order order = new Order();
        doNothing().when(emailService).sendEmail(anyString(), anyString());
        orderService.save(order);
        verify(orderRepo, times(1)).save(order);
        verify(emailService, times(1)).sendEmail(eq("Order saved"), contains("Object: " + order));
    }

    @Test
    void findAll_shouldReturnAllOrders() {
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);
        when(orderRepo.findAll()).thenReturn(orders);
        assertEquals(orders, orderService.findAll());
    }

    @Test
    void deleteById_shouldDeleteOrderById() {
        Long id = 1L;
        orderService.deleteById(id);
        verify(orderRepo, times(1)).deleteById(id);
    }

    @Test
    void findById_shouldReturnOrderById() {
        Long id = 1L;
        Order order = new Order();
        when(myOrderRepo.findById(id)).thenReturn(order);
        assertEquals(order, orderService.findById(id));
    }

    @Test
    void filter_shouldFilterOrdersByDate() {
        String date = "2022-01-01";
        List<Order> orders = Arrays.asList(new Order(), new Order());
        when(myOrderRepo.filter(date)).thenReturn(orders);
        assertEquals(orders, orderService.filter(date));
    }
}