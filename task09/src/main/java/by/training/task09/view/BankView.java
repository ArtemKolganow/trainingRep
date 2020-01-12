package by.training.task09.view;

import by.training.task09.entity.bank.Account;
import by.training.task09.entity.bank.Client;

public class BankView extends View {


    @Override
    public void showMenu(){
        System.out.println("Задание 2: ");
        System.out.println("1- Показать все счета.");
        System.out.println("2- Добавить счет.");
        System.out.println("3- Блокировка.");
        System.out.println("4- Разблокировка.");
        System.out.println("5- Поиск.");
        System.out.println("6- Сортировка.");
        System.out.println("7- Вычесление суммы по всем счетам.");
        System.out.println("8- Вычесление суммы по положительным счетам.");
        System.out.println("9- Вычесление суммы по отрицательным счетам.");
        System.out.println("0- Выход");
    }

    public void showAccount(Account account){
        System.out.println(account.toString());
    }

    public void showAllAccounts(Client client){
        if(client.getAccounts().size()!=0) {
            for (int i = 0; i < client.getAccounts().size(); i++) {
                System.out.println(client.getAccounts().get(i).toString());
            }
        }else {
            System.out.println("Счета отсутсвуют.");
        }
    }

    public Account getAccount() throws InputException {
        return new Account(readInt("Введите номер счета: "),readInt("Введите баланс счета: "));
    }
}
