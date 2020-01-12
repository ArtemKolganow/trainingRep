package by.training.task09.entity.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String name;
    private List<Account> accounts;

    public Client() {
        accounts = new ArrayList<>();
    }

    public Client(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void block(int number){
        Account account = accounts.get(number);
        account.setBlock(true);
    }

    public void unblock(int number){
        Account account = accounts.get(number);
        account.setBlock(false);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accounts);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
