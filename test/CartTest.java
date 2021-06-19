import com.tw.domain.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tw.domain.WeightUnit.KILOGRAM;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    public void cartDriver() {
        Cart cart = new Cart();

        Map<String, Price> competitorPrice = new HashMap<>();
        String iPadPro = "Ipad Pro";
        String heroPen = "Hero ink Pen";
        String cricketBat = "GM Cricket Bat";
        competitorPrice.put(iPadPro, new Price(20));
        competitorPrice.put(heroPen, new Price(30));
        competitorPrice.put(cricketBat, new Price(40.00));

        Product ipadPro = getProduct(competitorPrice, iPadPro);

        cart.addProduct(ipadPro, 1);
        cart.addProduct(getProduct(competitorPrice, heroPen), 1);
        cart.addProduct(getProduct(competitorPrice, cricketBat), 2);

        List<Item> cartItems = cart.getCartItems();

        assertEquals(3, cartItems.size());
        assertEquals(2, cartItems.get(2).getQuantity());

        cart.remove(ipadPro);

        assertEquals(2, cartItems.size());
        assertTrue(cart.getRemovedProductLog().contains(ipadPro));

        Order order = cart.checkout();

        assertEquals(110, order.getAmount().getValue());

        assertTrue(cart.isCheckedOut());
        assertNotNull(order);
    }

    private Product getProduct(Map<String, Price> competitorPrice, String productName) {
        return new Product(productName, new Weight(2, KILOGRAM), competitorPrice.get(productName));
    }

    @Test
    void compareCarts() {
        Cart cart1 = new Cart();
        Product ipadPro = new Product("Ipad Pro", new Weight(2, KILOGRAM), new Price(10.00));
        cart1.addProduct(ipadPro, 1);

        Cart cart2 = new Cart();
        cart2.addProduct(ipadPro, 1);

        assertNotEquals(cart1, cart2);
    }
}
