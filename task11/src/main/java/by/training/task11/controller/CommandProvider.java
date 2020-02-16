package by.training.task11.controller;



import by.training.task11.controller.command.*;

import java.util.HashMap;
import java.util.Map;

class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {

        repository.put(CommandName.EXIT,new ExitRequest());
        repository.put(CommandName.WRONG,new WrongRequest());
        repository.put(CommandName.SHOW,new ShowRequest());
        repository.put(CommandName.READ,new ReadRequest());
        repository.put(CommandName.SORT_PARAGRAPH,new SortParagraphRequest());
        repository.put(CommandName.SORT_SENTENCE,new SortSentenceRequest());
        repository.put(CommandName.SORT_LEXEME,new SortLexemeRequest());
    }

    Command getCommand(String name){
        CommandName commandName;
        Command command;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(IllegalArgumentException | NullPointerException e){
            command = repository.get(CommandName.WRONG);
        }
        return command;
    }
}
