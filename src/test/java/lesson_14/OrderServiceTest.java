package lesson_14;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

    @Test
    void testOneItemVipTypeCalc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", 4d, 1));

        Double result = OrderService.calc(items, Type.VIP);
        assertEquals(3.6d, result);
    }

    @Test
    void testOneItemNewTypeCalc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", 5d, 1));

        Double result = OrderService.calc(items, Type.NEW);
        assertEquals(4.75d, result);
    }

    @Test
    void testSumOverKItemNewTypeCalc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", 5d, 15));
        items.add(new Item("item2", 50d, 125));

        Double result = OrderService.calc(items, Type.NEW);
        assertEquals(5958.75d, result);
    }
}
