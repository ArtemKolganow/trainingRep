package by.training.task11.entity;

public class Paragraph extends Composite {
    @Override
    public String collect() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Component i: children){
            stringBuilder.append(i.collect());
        }
        return stringBuilder.toString();
    }
}
