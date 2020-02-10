package by.training.task11.entity;


public class Leaf implements Component {
    private Character character;

    public Leaf(Character character) {
        this.character = character;
    }

    public Leaf() {
    }

    public String collect() {
        return character.toString();
    }
}
