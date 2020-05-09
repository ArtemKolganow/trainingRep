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
        repository.put(CommandName.TO_LOGIN_PAGE,new ToLoginPage());
        repository.put(CommandName.MAIN,new Main());
        repository.put(CommandName.LOGOUT,new LogOut());
        repository.put(CommandName.TO_REGISTRATION_PAGE,new ToRegistrationPage());
        repository.put(CommandName.REGISTRATION,new Registration());
        repository.put(CommandName.PROFILE,new Profile());
        repository.put(CommandName.ORDER_LIST,new OrderList());
        repository.put(CommandName.USER_LIST,new UserList());
        repository.put(CommandName.CRAFT_ORDER_LIST,new CraftOrderList());
        repository.put(CommandName.EDIT_PROFILE,new EditProfile());
        repository.put(CommandName.TO_ORDER,new ToOrder());
        repository.put(CommandName.BASKET,new Basket());
        repository.put(CommandName.CONFIRM_ORDER,new ConfirmOrder());
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
