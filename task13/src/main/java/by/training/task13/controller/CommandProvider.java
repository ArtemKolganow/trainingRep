package by.training.task13.controller;



import by.training.task13.controller.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.SAX,new SAXRequest());
        repository.put(CommandName.DOM,new DOMRequest());
        repository.put(CommandName.STAX,new STAXRequest());
        repository.put(CommandName.WRONG,new WrongRequest());
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
