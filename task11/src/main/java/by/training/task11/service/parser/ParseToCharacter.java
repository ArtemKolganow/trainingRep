package by.training.task11.service.parser;

import by.training.task11.entity.Composite;
import by.training.task11.entity.Leaf;


public class ParseToCharacter implements Parser {
    @Override
    public void parse(Composite composite, String string) {
        for(int i =0; i<string.length();i++){
            composite.add(new Leaf(string.charAt(i)));
        }
    }

}
