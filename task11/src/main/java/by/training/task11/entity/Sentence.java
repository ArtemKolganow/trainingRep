package by.training.task11.entity;

public class Sentence extends Composite {
    @Override
    public String collect() {
        String delimiter =" ";
        StringBuilder stringBuilder = new StringBuilder();
        for(Component i: children){
            stringBuilder.append(i.collect()).append(delimiter);
        }
        return stringBuilder.toString();
    }
}
