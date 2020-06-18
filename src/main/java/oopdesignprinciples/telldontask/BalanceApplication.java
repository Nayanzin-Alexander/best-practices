package oopdesignprinciples.telldontask;

import java.math.BigDecimal;

public class BalanceApplication {

    public static void main(String[] args) {
        Account userAccount = new Account(10L, BigDecimal.valueOf(1000_000));

        // Tell don't ask principle
        BigDecimal currentBalance;
        currentBalance = userAccount.deposit(BigDecimal.valueOf(1_000_000));
        currentBalance = userAccount.withdraw(new BigDecimal(1_000_000));

        // Procedural style
        /*
        userAccount.setBalance(userAccount.getBalance().add(BigDecimal.valueOf(1_000_000)));
        currentBalance = userAccount.getBalance();
        userAccount.setBalance(userAccount.getBalance().subtract(BigDecimal.valueOf(1_000_000)));
        currentBalance = userAccount.getBalance();
         */
    }
}
