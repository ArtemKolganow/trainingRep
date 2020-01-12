package by.training.task09.view;

import by.training.task09.entity.text.Text;

public class TextView extends View {

    @Override
    public void showMenu(){
        System.out.println("Задание 1: ");
        System.out.println("1- Добавить предложение");
        System.out.println("2- Показать текст");
        System.out.println("3- Показать заголовок текста");
        System.out.println("0- Выход");
    }

    public void showText(Text text){
        System.out.println(text.toString());
    }
}
