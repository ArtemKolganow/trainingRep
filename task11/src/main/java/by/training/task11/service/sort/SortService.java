package by.training.task11.service.sort;

import by.training.task11.entity.*;
import by.training.task11.service.ServiceException;
import by.training.task11.service.parser.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class SortService {
    public void sortParagraph(Composite composite) throws ServiceException {
        List<Component> components = new LinkedList<>();
        for (int i = 0; i < composite.getChildrenSize(); i++) {
            components.add(composite.getChild(i));
        }
        if (components.get(0).getClass().equals(Paragraph.class)) {
            sortBySize(components);
            for (int i = 0; i < components.size(); i++) {
                composite.setChild(i, components.get(i));
            }
        } else {
            throw new ServiceException("Ошибка типа класса.");
        }
    }

    public String sortSentence(Composite composite, int numberOfParagraph, int numberOfSentence) throws ServiceException {
        if (composite.getClass().equals(Text.class)) {
            try {
                Component paragraph = composite.getChild(numberOfParagraph);
                Component sentence = paragraph.getChild(numberOfSentence);

                for (int i = 0; i < sentence.getChildrenSize() - 1; i++) {
                    Component tempI = sentence.getChild(i);
                    for (int j = i + 1; j < sentence.getChildrenSize(); j++) {
                        Component tempJ = sentence.getChild(j);
                        if (tempI.getChild(0).getChildrenSize() < tempJ.getChild(0).getChildrenSize()) {
                            sentence.setChild(i, tempJ);
                            sentence.setChild(j, tempI);
                            tempI = tempJ;
                        }
                    }
                }
                return sentence.collect();
            } catch (CompositeException e) {
                throw new ServiceException(e);
            }

        } else {
            throw new ServiceException("Ошибка типа композита.");
        }

    }

    public String sortLexeme(Composite composite, Character character) throws ServiceException {
        if (composite.getClass().equals(Text.class)) {
            try {
                Parser parser = formParser();
                Text localText = new Text();
                parser.parse(localText, composite.collect());
                sortTextLexeme(localText, character);
                return localText.collect();
            } catch (CompositeException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Ошибка типа композита.");
        }
    }

    private void sortBySize(List<Component> components) {
        for (int i = 0; i < components.size() - 1; i++) {
            Composite tempI = (Composite) components.get(i);
            for (int j = i + 1; j < components.size(); j++) {
                Composite tempJ = (Composite) components.get(j);
                if (tempI.getChildrenSize() < tempJ.getChildrenSize()) {
                    components.set(i, tempJ);
                    components.set(j, tempI);
                    tempI = tempJ;
                }
            }
        }
    }

    private Parser formParser() {
        Parser toChar = new ParseToCharacter();
        return new ParseToLexeme(toChar);
    }

    private int counter(Component component, Character character) throws CompositeException {
        int counter = 0;
        for (int i = 0; i < component.getChildrenSize(); i++) {
            if (component.getChild(i).collect().equals(character.toString())) {
                counter++;
            }
        }
        return counter;
    }

    private void sortTextLexeme(Text localText, Character character) throws CompositeException {
        for (int i = 0; i < localText.getChildrenSize() - 1; i++) {
            for (int j = i + 1; j < localText.getChildrenSize(); j++) {
                if (counter(localText.getChild(i), character) < counter(localText.getChild(j), character)) {
                    Component temp = localText.getChild(i);
                    localText.setChild(i, localText.getChild(j));
                    localText.setChild(j, temp);
                } else if (counter(localText.getChild(i), character) == counter(localText.getChild(j), character)) {
                    String stringI = localText.getChild(i).collect();
                    String stringJ = localText.getChild(j).collect();
                    int length = Math.min(stringI.length(), stringJ.length());
                    for (int k = 0; k < length; k++) {
                        if (stringI.charAt(k) != stringJ.charAt(k)) {
                            if (stringI.charAt(k) > stringJ.charAt(k)) {
                                Component temp = localText.getChild(i);
                                localText.setChild(i, localText.getChild(j));
                                localText.setChild(j, temp);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

}
