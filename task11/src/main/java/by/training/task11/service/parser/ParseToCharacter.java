package by.training.task11.service.parser;

import by.training.task11.entity.Composite;
import by.training.task11.entity.Leaf;

import java.util.List;

public class ParseToCharacter implements Parser {
    @Override
    public void parse(Composite composite, String string, List<Parser> parsers, int index) {
        for(int i =0; i<string.length();i++){
            composite.add(new Leaf(string.charAt(i)));
        }
    }

}
