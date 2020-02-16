package by.training.task11.service.parser;

import by.training.task11.entity.Composite;
import by.training.task11.entity.Paragraph;

public class ParseToParagraph implements Parser {
    private static final String REG = "([\\n\\r])(\\t| {4})";
    private Parser next;

    public ParseToParagraph(Parser next) {
        this.next = next;
    }

    @Override
    public void parse(Composite composite, String string) {
        String[] paragraphs = string.split(REG);
        for(String i: paragraphs){
            Paragraph paragraph = new Paragraph();
            next.parse(paragraph,i.trim());
            composite.add(paragraph);
        }
    }
}
