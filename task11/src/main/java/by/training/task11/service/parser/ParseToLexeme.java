package by.training.task11.service.parser;

import by.training.task11.entity.Composite;
import by.training.task11.entity.Lexeme;


public class ParseToLexeme implements Parser {
    private static final String REG = " +";
    private Parser next;

    public ParseToLexeme(Parser next) {
        this.next = next;
    }

    @Override
    public void parse(Composite composite, String string) {
        String[] lexemes = string.split(REG);
        for(String i: lexemes){
            Lexeme lexeme = new Lexeme();
            next.parse(lexeme,i);
            composite.add(lexeme);
        }
    }
}
