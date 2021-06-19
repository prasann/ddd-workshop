import com.tw.domain.Cart;
import com.tw.domain.Item;
import com.tw.domain.Price;
import com.tw.domain.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    public void cartDriver() {
        Cart cart = new Cart();

        Product ipadPro = new Product("Ipad Pro", new Price(10.00));
        System.out.println(ipadPro.getPrice());
        cart.addProduct(ipadPro, 1);
        cart.addProduct(new Product("Hero ink Pen", new Price(5.50)), 1);
        cart.addProduct(new Product("GM Cricket Bat", new Price(20.00)), 2);

        List<Item> cartItems = cart.getCartItems();

        assertEquals(3, cartItems.size());
        assertEquals(2, cartItems.get(2).getQuantity());

        cart.remove(ipadPro);

        assertEquals(2, cartItems.size());
        assertTrue(cart.getRemovedProductLog().contains(ipadPro));
    }

    @Test
    void compareCarts() {
        Cart cart1 = new Cart();
        Product ipadPro = new Product("Ipad Pro", new Price(10.00));
        cart1.addProduct(ipadPro, 1);

        Cart cart2 = new Cart();
        cart2.addProduct(ipadPro, 1);

        assertNotEquals(cart1, cart2);
    }
}
