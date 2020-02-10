package by.training.task11.service.parser;

import by.training.task11.entity.Composite;
import by.training.task11.entity.Mark;
import by.training.task11.entity.Word;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseToWord implements Parser {
    private static final String REG = "\\w+";
    @Override
    public void parse(Composite composite, String string, List<Parser> parsers, int index) {
        Parser parser = parsers.get(index);
        index++;
        Pattern pattern =Pattern.compile(REG);
        Matcher matcher = pattern.matcher(string);
        if(matcher.find()){
            Word word = new Word();
            String wordString = string.substring(matcher.start(),matcher.end());
            parser.parse(word,wordString,parsers,index);
            composite.add(word);
            if(!wordString.equals(string)){
                String markString = string.substring(matcher.end());
                Mark mark = new Mark();
                parser.parse(mark,markString,parsers,index);
                composite.add(mark);
            }
        }
    }
}
