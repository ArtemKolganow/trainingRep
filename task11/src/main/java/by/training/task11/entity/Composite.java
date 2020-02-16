package by.training.task11.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    List<Component> children;

    public Composite() {
        this.children = new ArrayList<>();
    }

    public String collect(){
        return null;
    }

    public void setChild(int i, Component component){
        children.set(i,component);
    }

    public void add(Component child){
        this.children.add(child);
    }

    public Component getChild(int i){
        return children.get(i);
    }

    public int getChildrenSize(){
        return children.size();
    }
}
