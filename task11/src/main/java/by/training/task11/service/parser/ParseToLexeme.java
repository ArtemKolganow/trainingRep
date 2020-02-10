package by.training.task11.service.parser;

import by.training.task11.entity.Composite;
import by.training.task11.entity.Lexeme;

import java.util.List;

public class ParseToLexeme implements Parser {
    private static final String REG = " ";

    @Override
    public void parse(Composite composite, String string, List<Parser> parsers, int index) {
        Parser parser = parsers.get(index);
        index++;
        String[] lexemes = string.split(REG);
        for(String i: lexemes){
            Lexeme lexeme = new Lexeme();
            parser.parse(lexeme,i,parsers,index);
            composite.add(lexeme);
        }
    }
}
