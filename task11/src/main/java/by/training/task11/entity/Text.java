package by.training.task11.entity;

public class Text extends Composite {
    @Override
    public String collect() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Component i: children){
            stringBuilder.append("\n\t").append(i.collect());
        }
        return stringBuilder.toString();
    }
}
