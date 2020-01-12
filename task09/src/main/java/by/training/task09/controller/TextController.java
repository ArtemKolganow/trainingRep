package by.training.task09.controller;

import by.training.task09.entity.text.Text;
import by.training.task09.serice.TextService;
import by.training.task09.view.InputException;
import by.training.task09.view.TextView;

public class TextController {
    public void exerciseOne(){
        TextView view= new TextView();
        TextService service = new TextService();
        boolean exit = false;
        Text text= new Text(view.readString("Введите заголовок текста: "));
        while (!exit){
            try {
                view.showMenu();
                switch (view.readInt("Выберите пункт: ")){
                    case 0: {
                        exit = true;
                        break;
                    }
                    case 1:{
                        service.addSentence(text,view.readString("Введите предложение: "),
                                view.readInt("Введите позицию: "));
                        break;
                    }
                    case 2:{
                        view.showMassage(text.getName());
                        view.showText(text);
                        break;
                    }
                    case 3:{
                        view.showMassage(text.getName());
                        break;
                    }
                    default:{
                        view.showMassage("Некорректный ввод.");
                    }
                }
            } catch (InputException e) {
                view.showMassage(e.getMessage());
            }
        }
    }
}
