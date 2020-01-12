package by.training.task09.entity.text;

import java.util.ArrayList;
import java.util.Objects;

public class Sentence {
    private ArrayList<Word> words;

    public Sentence() {
        words = new ArrayList<>();
    }

    public Sentence(String sentence) {
        sentence = sentence.trim();
        words = new ArrayList<>();
        int wordIndex = 0;
        for(int i = 0; i<sentence.length();i++){
            if(sentence.charAt(i)=='.'||sentence.charAt(i)=='!'||sentence.charAt(i)=='?'){
                words.add(new Word(sentence.substring(wordIndex,i+1)));
                break;
            }
            if(sentence.charAt(i)==' '){
                words.add(new Word(sentence.substring(wordIndex,i)));
                wordIndex=i+1;
            }
        }

    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(words, sentence.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    @Override
    public String toString() {
        String res = "";
        for (Word word : words) {
            res+= word.toString() + " ";
        }
        return res;
    }
}
