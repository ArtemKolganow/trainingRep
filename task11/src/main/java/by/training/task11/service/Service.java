package by.training.task11.service;

import by.training.task11.dal.DataException;
import by.training.task11.dal.DataReader;
import by.training.task11.dal.Reader;
import by.training.task11.entity.Component;
import by.training.task11.entity.Composite;
import by.training.task11.service.parser.*;

public class Service {

    public void readText(String path, Component text) throws ServiceException {
        DataReader reader = new Reader();
        String textString;
        try {
            textString = reader.readData(path);
        } catch (DataException e) {
            throw new ServiceException(e);
        }
        Parser parser = formChainOfParser();
       parser.parse((Composite) text, textString);
    }

    public Parser formChainOfParser(){
        Parser toChar = new ParseToCharacter();
        Parser toWord = new ParseToWord(toChar);
        Parser toLexeme = new ParseToLexeme(toWord);
        Parser toSentence = new ParseToSentence(toLexeme);
        return new ParseToParagraph(toSentence);
    }
}
