package by.training.task09.entity.bank;

import java.util.Objects;

public class Account {
    private int accountNumber;
    private int accountBalance;
    private boolean block;

    public Account(int accountNumber, int accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.block = false;
    }

    public Account() {
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber &&
                accountBalance == account.accountBalance &&
                block == account.block;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountBalance, block);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                ", block=" + block +
                '}';
    }
}
