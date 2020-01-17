package by.training.task10treasures.controller;



import by.training.task10treasures.controller.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ADD,new AddToBackpack());
        repository.put(CommandName.GENERATE,new GenerateNewFile());
        repository.put(CommandName.CHANGE,new ChangePath());
        repository.put(CommandName.DELETE,new DeleteFromBackpack());
        repository.put(CommandName.EXIT,new ExitRequest());
        repository.put(CommandName.SHOW,new ShowListOfTreasure());
        repository.put(CommandName.WRONG,new WrongRequest());
        repository.put(CommandName.LIMIT,new SetLimit());
        repository.put(CommandName.MAX,new ShowMaxPrice());
        repository.put(CommandName.CHECK,new CheckBackpack());
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
