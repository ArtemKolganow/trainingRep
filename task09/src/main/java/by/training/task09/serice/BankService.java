package by.training.task09.serice;

import by.training.task09.entity.bank.Account;
import by.training.task09.entity.bank.Client;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    public void addAccountToClient(Client client, Account account) throws AccountException {
        if (account.getAccountNumber() < 0) {
            throw new AccountException("Номер не может быть отрицательным.");
        }
        List<Account> accounts = client.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber()==account.getAccountNumber()){
                throw new AccountException("Номер не может повторятся.");
            }
        }
        client.addAccount(account);

    }

    public void block(Client client, int number) throws AccountException {
        int numberOfElement = search(client, number);
        client.block(numberOfElement);
    }

    public void unblock(Client client, int number) throws AccountException {
        int numberOfElement = search(client, number);
        client.unblock(numberOfElement);
    }

    public int search(Client client, int number) throws AccountException {
        List<Account> accounts = client.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == number) {
                return i;
            }
        }
        throw new AccountException("Элемент с таким номером отсутствует.");
    }

    public void sort(Client client) {
        List<Account> accounts = client.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 0; j < accounts.size() - i - 1; j++) {
                if (accounts.get(j + 1).getAccountNumber() < accounts.get(j).getAccountNumber()) {
                    Account temp = accounts.get(j);
                    accounts.set(j, accounts.get(j + 1));
                    accounts.set(j + 1, temp);
                }
            }
        }
        client.setAccounts(accounts);
    }

    public int calculateSum(Client client) {
        int sum = 0;
        List<Account> accounts = client.getAccounts();
        for (Account account : accounts) {
            sum += account.getAccountBalance();
        }
        return sum;
    }

    public int calculatePositiveSum(Client client) {
        int sum = 0;
        List<Account> accounts = client.getAccounts();
        for (Account account : accounts) {
            if (account.getAccountBalance() > 0) {
                sum += account.getAccountBalance();
            }
        }
        return sum;
    }

    public int calculateNegativeSum(Client client) {
        int sum = 0;
        List<Account> accounts = client.getAccounts();
        for (Account account : accounts) {
            if (account.getAccountBalance() < 0) {
                sum += account.getAccountBalance();
            }
        }
        return sum;
    }
}
