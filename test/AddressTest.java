import com.finance.tw.domain.Account;
import com.finance.tw.domain.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {
    @Test
    void shouldUpdateAddress() {
        String oldAddress = "oldAddress";

        Customer customer = new Customer(oldAddress);
        Account account1 = new Account(oldAddress);
        Account account2 = new Account(oldAddress);
        customer.addAccount(account1);
        customer.addAccount(account2);

        String newAddress = "newAddress";
        customer.updateAddress(newAddress);

        assertEquals(newAddress, customer.getAddress());
        assertEquals(newAddress, account1.getAddress());
        assertEquals(newAddress, account2.getAddress());
    }
}
