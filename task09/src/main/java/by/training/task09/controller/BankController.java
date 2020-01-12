package by.training.task09.controller;

import by.training.task09.entity.bank.Client;
import by.training.task09.serice.AccountException;
import by.training.task09.serice.BankService;
import by.training.task09.view.BankView;
import by.training.task09.view.InputException;

public class BankController {
    public void exerciseTwo(){
        BankView view = new BankView();
        BankService service = new BankService();
        boolean exit = false;
        Client client = new Client(view.readString("Введите имя клиента: "));
        while (!exit){
            try {
                view.showMenu();
                switch (view.readInt("Выберите пункт: ")){
                    case 0: {
                        exit = true;
                        break;
                    }
                    case 1:{
                        view.showAllAccounts(client);
                        break;
                    }
                    case 2:{
                        try{
                            service.addAccountToClient(client,view.getAccount());
                        } catch (AccountException e) {
                            view.showMassage(e.getMessage());
                        }
                        break;
                    }
                    case 3:{
                        try {
                            service.block(client,view.readInt("Введите номер блокируемого счета: "));
                        } catch (AccountException e) {
                            view.showMassage(e.getMessage());
                        }
                        break;
                    }
                    case 4:{
                        try {
                            service.unblock(client,view.readInt("Введите номер счета: "));
                        } catch (AccountException e) {
                            view.showMassage(e.getMessage());
                        }
                        break;
                    }
                    case 5:{
                        try {
                            view.showAccount(client.getAccounts().get(service.search(client,view.readInt("Введите номер счета: "))));
                        } catch (AccountException e) {
                            view.showMassage(e.getMessage());
                        }
                        break;
                    }
                    case 6:{
                        service.sort(client);
                        view.showAllAccounts(client);
                        break;
                    }
                    case 7:{
                        view.showMassage("Сумма всех счетов: " + service.calculateSum(client));
                        break;
                    }
                    case 8:{
                        view.showMassage("Сумма положительных счетов: " + service.calculatePositiveSum(client));
                        break;
                    }
                    case 9:{
                        view.showMassage("Сумма отрицательных счетов: " + service.calculateNegativeSum(client));
                        break;
                    }
                    default:{
                        view.showMassage("Некорректный ввод.");
                    }
                }
            } catch (InputException e) {
                view.showMassage(e.getMessage());
            }
        }
    }
}
