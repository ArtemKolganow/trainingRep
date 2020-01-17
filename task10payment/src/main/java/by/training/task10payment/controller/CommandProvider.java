package by.training.task10payment.controller;

import by.training.task10payment.controller.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ADD,new AddToPayment());
        repository.put(CommandName.CREATE,new CreateNewProduct());
        repository.put(CommandName.CHANGE,new ChangePath());
        repository.put(CommandName.DELETE,new DeleteFromPayment());
        repository.put(CommandName.EXIT,new ExitRequest());
        repository.put(CommandName.SHOW,new ShowProducts());
        repository.put(CommandName.WRONG,new WrongRequest());
        repository.put(CommandName.VIEW,new ViewPayment());
    }

    Command getCommand(String name){
        CommandName commandName =null;
        Command command = null;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(IllegalArgumentException | NullPointerException e){
            command = repository.get(CommandName.WRONG);
        }
        return command;
    }
}
