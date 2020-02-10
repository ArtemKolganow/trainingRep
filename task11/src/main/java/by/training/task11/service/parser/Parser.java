package by.training.task11.service.parser;

import by.training.task11.entity.Composite;

import java.util.List;

public interface Parser {
    void parse(Composite composite, String string, List<Parser> parsers, int index);
}
