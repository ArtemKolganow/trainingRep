package by.training.task11.entity;

public interface Component {
    String collect();
    void setChild(int i, Component component) throws CompositeException;
    void add(Component child) throws CompositeException;
    Component getChild(int i) throws CompositeException;
    int getChildrenSize() throws CompositeException;
}
