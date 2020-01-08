package by.training.task09.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Text {
    private ArrayList<Sentence> textContent;
    private String name;

    public Text(String name) {
        this.name = name;
        textContent = new ArrayList<>();
    }

    public Text() {
        textContent = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return Objects.equals(textContent, text1.textContent) &&
                Objects.equals(name, text1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textContent, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Sentence> getTextContent() {
        return textContent;
    }

    public void setTextContent(ArrayList<Sentence> textContent) {
        this.textContent.addAll(textContent);
    }

    public void setText(Sentence sentence) {
        this.textContent.add(sentence);
    }

    public void setText(Sentence sentence, int pos) {
        if(!this.textContent.isEmpty()&&pos<this.textContent.size()) {
            this.textContent.add(pos, sentence);
        }else {
            this.textContent.add(sentence);
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (Sentence sentence : textContent) {
            res+= sentence.toString();
        }
        return res;
    }
}
