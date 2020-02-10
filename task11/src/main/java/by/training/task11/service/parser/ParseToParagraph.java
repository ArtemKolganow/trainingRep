package by.training.task11.service.parser;

import by.training.task11.entity.Composite;
import by.training.task11.entity.Paragraph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ParseToParagraph implements Parser {
    private static final String REG = "([\\n\\r])(\\t| {4})";

    @Override
    public void parse(Composite composite, String string, List<Parser> parsers, int index) {
        Parser parser = parsers.get(index);
        index++;
        String[] paragraphs = string.split(REG);
        for(String i: paragraphs){
            Paragraph paragraph = new Paragraph();
            parser.parse(paragraph,i.trim(),parsers,index);
            composite.add(paragraph);
        }
    }
}
