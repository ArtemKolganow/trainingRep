package by.training.task11.service.sort;

import by.training.task11.entity.*;
import by.training.task11.service.ServiceException;

import java.util.List;

public class SortService {
    public void sortParagraph(Composite composite) throws ServiceException {
        List<Component> components = composite.getChildren();
        if(components.get(0).getClass().equals(Paragraph.class)) {
            sortBySize(components);
            composite.setChildren(components);
        }else{
            throw new ServiceException("Ошибка типа класса.");
        }
    }

    public void sortSentence(Composite composite, int numberOfParagraph, int numberOfSentence) throws ServiceException {
        if(composite.getClass().equals(Text.class)){
           Composite com = (Composite) composite.getChildren().get(numberOfParagraph);
           com = (Composite) com.getChildren().get(numberOfSentence);
           List<Component> components = com.getChildren();
           sortBySize(components);
           com.setChildren(components);
        }else {
            throw new ServiceException("Ошибка типа композита.");
        }

    }

    private void sortBySize(List<Component> components){
        for (int i = 0; i < components.size()-1; i++) {
            Composite tempI = (Composite) components.get(i);
            for(int j = i+1; j< components.size();j++){
                Composite tempJ = (Composite) components.get(j);
                if(tempI.getChildren().size()<tempJ.getChildren().size()){
                    components.set(i,tempJ);
                    components.set(j,tempI);
                    tempI = tempJ;
                }
            }
        }
    }


}
