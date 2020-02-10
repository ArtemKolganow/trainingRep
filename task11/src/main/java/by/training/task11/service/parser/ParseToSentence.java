package by.training.task11.service.parser;

import by.training.task11.entity.Composite;
import by.training.task11.entity.Sentence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseToSentence implements Parser {
    private static final String REG = "[^.?!]+[.?!]+";
    @Override
    public void parse(Composite composite, String string, List<Parser> parsers, int index) {
        Parser parser = parsers.get(index);
        index++;
        Pattern pattern = Pattern.compile(REG);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()){
            String sentenceString = string.substring(matcher.start(),matcher.end());
            Sentence sentence = new Sentence();
            parser.parse(sentence,sentenceString,parsers,index);
            composite.add(sentence);
        }

    }
}
