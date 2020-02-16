package by.training.task11.service.parser;

import by.training.task11.entity.Composite;
import by.training.task11.entity.Mark;
import by.training.task11.entity.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseToWord implements Parser {
    private static final String REG = "\\w+";
    private Parser next;

    public ParseToWord(Parser next) {
        this.next = next;
    }

    @Override
    public void parse(Composite composite, String string) {
        Pattern pattern =Pattern.compile(REG);
        Matcher matcher = pattern.matcher(string);
        if(matcher.find()){
            Word word = new Word();
            String wordString = string.substring(matcher.start(),matcher.end());
            next.parse(word,wordString);
            composite.add(word);
            if(!wordString.equals(string)){
                String markString = string.substring(matcher.end());
                Mark mark = new Mark();
                next.parse(mark,markString);
                composite.add(mark);
            }
        }
    }
}
