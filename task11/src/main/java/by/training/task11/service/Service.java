package by.training.task11.service;

import by.training.task11.dal.DataException;
import by.training.task11.dal.DataReader;
import by.training.task11.dal.Reader;
import by.training.task11.entity.Component;
import by.training.task11.entity.Composite;
import by.training.task11.entity.Text;
import by.training.task11.service.parser.*;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public void readText(String path, Component text) throws ServiceException {
        DataReader reader = new Reader();
        String textString;
        try {
            textString = reader.readData(path);
        } catch (DataException e) {
            throw new ServiceException(e);
        }
        int index =0;
        List<Parser> parserList = formListOfParser();
        parserList.get(index++).parse((Composite) text,textString,parserList,index);
    }

    private List<Parser> formListOfParser(){
        List<Parser> parserList = new ArrayList<>();
        parserList.add(new ParseToParagraph());
        parserList.add(new ParseToSentence());
        parserList.add(new ParseToLexeme());
        parserList.add(new ParseToWord());
        parserList.add(new ParseToCharacter());
        return parserList;
    }
}
