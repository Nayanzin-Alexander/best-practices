package telldontask;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private Long userId;
    private BigDecimal balance;

    public BigDecimal deposit(BigDecimal augend) {
        this.balance = balance.add(augend);
        return cloneBalance();
    }

    public BigDecimal withdraw(BigDecimal subtrahend) {
        balance = balance.subtract(subtrahend);
        return cloneBalance();
    }

    private BigDecimal cloneBalance() {
        return new BigDecimal(balance.toString());
    }
}
