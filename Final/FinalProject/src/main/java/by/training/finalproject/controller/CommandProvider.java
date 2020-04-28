package by.training.finalproject.controller;



import by.training.finalproject.controller.command.*;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new EnumMap<>(CommandName.class);

    CommandProvider() {
        repository.put(CommandName.WRONG,new WrongRequest());
        repository.put(CommandName.LOGIN,new Login());
        repository.put(CommandName.TOLOGINPAGE,new ToLoginPage());
        repository.put(CommandName.MAIN,new Main());
        repository.put(CommandName.LOGOUT,new LogOut());
        repository.put(CommandName.TOREGISTRATIONPAGE,new ToRegistrationPage());
        repository.put(CommandName.REGISTRATION,new Registration());
        repository.put(CommandName.PROFILE,new Profile());
        repository.put(CommandName.ORDERLIST,new OrderList());

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
