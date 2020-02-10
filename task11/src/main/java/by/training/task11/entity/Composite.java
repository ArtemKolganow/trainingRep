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

    public void setChildren(List<Component> children) {
        this.children = children;
    }

    public void add(Component child){
        this.children.add(child);
    }

    public List<Component> getChildren() {
        return children;
    }
}
