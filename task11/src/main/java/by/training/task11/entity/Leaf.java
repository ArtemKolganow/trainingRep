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

    @Override
    public void setChild(int i, Component component) throws CompositeException {
        throw new CompositeException("Попытка сета у листа.");
    }

    @Override
    public void add(Component child) throws CompositeException {
        throw new CompositeException("Попытка добавления у листа.");
    }

    @Override
    public Component getChild(int i) throws CompositeException {
        throw new CompositeException("Попытка гета у листа.");
    }

    @Override
    public int getChildrenSize() throws CompositeException {
        throw new CompositeException("Попытка получения размера у листа.");
    }
}
