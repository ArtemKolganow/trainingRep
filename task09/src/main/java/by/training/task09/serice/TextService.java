package by.training.task09.serice;

import by.training.task09.entity.Sentence;
import by.training.task09.entity.Text;

public class TextService {
    public void addSentence(Text text,String sentence, int position){
        text.setText(new Sentence(sentence),position);

    }
}
