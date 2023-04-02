package hello.test;

import hello.EmailService;
import hello.item.Item;
import hello.item.ItemRepo;
import hello.item.ItemService;
import hello.item.MyItemRepo;
import hello.order.MyOrderRepo;
import hello.order.Order;
import hello.order.OrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    private ItemService itemService;

    @Mock
    private ItemRepo itemRepo;

    @Mock
    private OrderRepo orderRepo;

    @Mock
    private MyItemRepo myItemRepo;

    @Mock
    private MyOrderRepo myOrderRepo;

    @Mock
    private EmailService emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        itemService = new ItemService(itemRepo, orderRepo, myItemRepo, myOrderRepo, emailService);
    }

    @Test
    void save() throws MessagingException {
        // given
        Item item = new Item("item1", "1231424314", 1245);
        item.setId(1L);
        Order order = new Order("14444");
        order.setId(1L);
        when(myOrderRepo.findById(order.getId())).thenReturn(order);
        doNothing().when(emailService).sendEmail(anyString(), anyString());

        // when
        itemService.save(item, order.getId());

        // then
        verify(itemRepo, times(1)).save(item);
    }

    @Test
    void findAll() {
        // given
        List<Item> items = new ArrayList<>();
        items.add(new Item());
        items.add(new Item());
        when(itemRepo.findAll()).thenReturn(items);

        // when
        List<Item> result = itemService.findAll();

        // then
        assertEquals(2, result.size());
        verify(itemRepo, times(1)).findAll();
    }

    @Test
    void deleteById() {
        // given
        long itemId = 1L;

        // when
        itemService.deleteById(itemId);

        // then
        verify(itemRepo, times(1)).deleteById(itemId);
    }

    @Test
    void findById() {
        // given
        Item item = new Item("item2","11111",44444);
        item.setId(1L);
        when(myItemRepo.findById(item.getId())).thenReturn(item);

        // when
        Item result = itemService.findById(item.getId());

        // then
        assertEquals(item, result);
        verify(myItemRepo, times(1)).findById(item.getId());
    }

    @Test
    void getOrder() {
        // given
        Item item = new Item();
        item.setId(1L);
        Order order = new Order();
        order.setId(1L);
        item.setOrder(order);
        when(myItemRepo.findById(item.getId())).thenReturn(item);

        // when
        Order result = itemService.getOrder(item.getId());

        // then
        assertEquals(order, result);
        verify(myItemRepo, times(1)).findById(item.getId());
    }

    @Test
    void filter() {
        // given
        List<Item> items = new ArrayList<>();
        items.add(new Item("item4", "131241", 2334));
        items.add(new Item("item5", "1312", 234));
        when(myItemRepo.filter("item4", null, null)).thenReturn(items);

        // when
        List<Item> result = itemService.filter("item4", null, null);

        // then
        assertEquals(2, result.size());
        verify(myItemRepo, times(1)).filter("item4", null, null);
    }

}